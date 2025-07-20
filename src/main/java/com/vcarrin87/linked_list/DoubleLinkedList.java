package com.vcarrin87.linked_list;

/**
 * A DoubleLinkedList represents a doubly linked list data structure.
 * It supports operations such as appending, prepending, deleting DoubleNodes,
 * and printing the list.
 */
public class DoubleLinkedList {

    DoubleNode head;
    DoubleNode tail;

    // Insert at the end
    public void append(int data) {
        DoubleNode newDoubleNode = new DoubleNode(data);
        if (head == null) {
            head = newDoubleNode;
            tail = newDoubleNode;
            return;
        }
        tail.next = newDoubleNode;
        newDoubleNode.prev = tail;
        tail = newDoubleNode;
    }

    // Insert at the beginning
    public void prepend(int data) {
        DoubleNode newDoubleNode = new DoubleNode(data);
        if (head == null) {
            head = newDoubleNode;
            tail = newDoubleNode;
            return;
        }
        newDoubleNode.next = head;
        head.prev = newDoubleNode;
        head = newDoubleNode;
    }

    // Delete first occurrence of key
    public void delete(int key) {
        if (head == null) return;

        DoubleNode current = head;
        while (current != null && current.data != key) {
            current = current.next;
        }

        if (current == null) return; // Key not found

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next; // Deleting head
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev; // Deleting tail
        }
    }

    // Print the list from head to tail
    public void printList() {
        DoubleNode current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}
