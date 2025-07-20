package com.vcarrin87.linked_list;

/**
 * A Linked List is a linear data structure where elements (nodes) are stored in a sequence.
 * Each node contains data and a reference (link) to the next node in the sequence.
 * Linked Lists allow efficient insertion and removal of elements from any position,
 * but accessing elements by index requires traversing from the head node.
 * There are several types of linked lists: singly linked, doubly linked, and circular linked lists.
 */

public class Main {

    public static void main(String[] args) {
        // Each node has data and a reference to the next node.
        // Traversal: Only forward (from head to tail).
        // Example:
        // 0 -> 1 -> 2 -> null
        // Use case: Simple, memory-efficient, but can’t traverse backward.
        // Example usage of a single linked list
        SingleLinkedList singlelist = new SingleLinkedList();
        singlelist.append(1);
        singlelist.append(2);
        singlelist.prepend(0);
        singlelist.printList(); // Output: 0 -> 1 -> 2
        singlelist.delete(1);
        singlelist.printList(); // Output: 0 -> 2

        // Each node has data, a reference to the next node, and a reference to the previous node.
        // Traversal: Forward and backward (from head to tail and tail to head).
        // Example:
        // null <-> 0 <-> 1 <-> 2 <-> null
        // Use case: More memory overhead, but allows bidirectional traversal.
        // Example usage of a double linked list
        DoubleLinkedList doubleList = new DoubleLinkedList();
        doubleList.append(1);
        doubleList.append(2);
        doubleList.prepend(0);
        doubleList.printList(); // Output: 0 <-> 1 <-> 2
        doubleList.delete(1);
        doubleList.printList(); // Output: 0 <-> 2

        // Each node has data and a reference to the next node, forming a circular structure.
        // Traversal: Can loop indefinitely (from head to head).
        // Example:
        // 0 ~ 1 ~ 2 (circular)
        // Use case: Useful for applications that require circular traversal, like round-robin scheduling.
        // Note: Be cautious with infinite loops; ensure a proper exit condition.
        // Example usage of a circular linked list
        CircularLinkedList circularList = new CircularLinkedList();
        circularList.append(1);
        circularList.append(2);
        circularList.prepend(0);
        circularList.printList(); // Output: 0 ~ 1 ~ 2 (circular)
        circularList.delete(1);
        circularList.printList(); // Output: 0 ~ 2 (circular)
    }
}
