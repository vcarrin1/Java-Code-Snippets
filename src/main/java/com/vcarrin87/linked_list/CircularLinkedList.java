package com.vcarrin87.linked_list;

/**
 * A CircularLinkedList represents a circular linked list data structure.
 * It supports operations such as appending, prepending, deleting nodes,
 * and printing the list.
 */
public class CircularLinkedList {

    CircularNode head;

    // Insert at the end
    public void append(int data) {
        CircularNode newNode = new CircularNode(data);
        if (head == null) {
            head = newNode;
            newNode.next = head; // Point to itself
            return;
        }
        CircularNode current = head;
        while (current.next != head) {
            current = current.next;
        }
        current.next = newNode;
        newNode.next = head; // Make it circular
    }

    // Insert at the beginning
    public void prepend(int data) {
        CircularNode newNode = new CircularNode(data);
        if (head == null) {
            head = newNode;
            newNode.next = head; // Point to itself
            return;
        }
        CircularNode current = head;
        while (current.next != head) {
            current = current.next;
        }
        newNode.next = head;
        head = newNode;
        current.next = head; // Update last node's next to point to new head
    }

    // Delete first occurrence of key
    public void delete(int key) {
        if (head == null) return;

        CircularNode current = head;
        CircularNode prev = null;

        do {
            if (current.data == key) {
                if (prev != null) {
                    prev.next = current.next; // Bypass the node to delete it
                } else {
                    // If we are deleting the head, find the last node
                    CircularNode last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    last.next = current.next; // Update last node's next
                    head = current.next; // Update head to next node
                }
                return; // Key found and deleted
            }
            prev = current;
            current = current.next;
        } while (current != head); // Loop until we come back to the head

    }

    // Print the list
    public void printList() {
        if (head == null) return;

        CircularNode current = head;
        do {
            System.out.print(current.data);
            current = current.next;
            if (current != head) {
                System.out.print(" ~ ");
            }
        } while (current != head);

        System.out.println();
    }
}
