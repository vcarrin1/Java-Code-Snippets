package com.vcarrin87.concurrency.reentrant_lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// A thread-safe bank account example with concurrency, we'll use ReentrantLock for synchronization. 
// This implementation ensures atomic deposits/withdrawals and prevents race conditions.
public class Main {

    public static void main(String[] args) {
        BankAccount account = new BankAccount(500);
        ExecutorService executor = Executors.newFixedThreadPool(4); // Pool of 4 threads

        try {
            System.out.printf("Initial balance: %.2f%n", account.getBalance());
            // Submit 4 tasks (2 deposits, 2 withdrawals)
            executor.submit(() -> account.deposit(200));
            executor.submit(() -> account.deposit(300));
            executor.submit(() -> account.withdraw(400));
            executor.submit(() -> account.withdraw(700));

            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.MINUTES);

        } catch (InterruptedException e) {
            System.err.println("Thread interrupted: " + e.getMessage());
        }
        
       System.out.printf("%nFinal balance: %.2f%n", account.getBalance());
    }
}

/*
 * Output:
    Initial balance: 500.00
    [pool-1-thread-1] Deposited: 200.00 | New Balance: 700.00
    [pool-1-thread-2] Deposited: 300.00 | New Balance: 1000.00
    [pool-1-thread-3] Withdrew: 400.00 | New Balance: 600.00
    [pool-1-thread-4] Failed withdrawal: 700.00 | Balance: 600.00

    Final balance: 600.00
 */
