package com.vcarrin87.concurrency.reentrant_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
    private final Lock lock = new ReentrantLock();

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
            System.out.printf("[%s] Deposited: %.2f | New Balance: %.2f%n",
                Thread.currentThread().getName(), amount, balance);
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
                System.out.printf("[%s] Withdrew: %.2f | New Balance: %.2f%n",
                    Thread.currentThread().getName(), amount, balance);
            } else {
                System.out.printf("[%s] Failed withdrawal: %.2f | Balance: %.2f%n",
                    Thread.currentThread().getName(), amount, balance);
            }
        } finally {
            lock.unlock();
        }
    }
}