package com.vcarrin87.linked_list;

/**
 * A SingleLinkedList represents a singly linked list data structure.
 * It supports operations such as appending, prepending, deleting SingleNodes,
 * and printing the list.
 */
public class SingleLinkedList {

    SingleNode head;

    // Insert at the end
    void append(int data) {
        SingleNode newSingleNode = new SingleNode(data);
        if (head == null) {
            head = newSingleNode;
            return;
        }
        SingleNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newSingleNode;
    }

    // Insert at the beginning
    void prepend(int data) {
        SingleNode newSingleNode = new SingleNode(data);
        newSingleNode.next = head;
        head = newSingleNode;
    }

    // Delete first occurrence of key
    void delete(int key) {
        if (head == null) return;
        if (head.data == key) {
            head = head.next;
            return;
        }
        SingleNode current = head;
        while (current.next != null && current.next.data != key) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // Print the list
    void printList() {
        SingleNode current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}