package com.vcarrin87.linked_list;

/**
 * A DoubleNode represents a single node in a doubly linked list.
 * Each DoubleNode contains data, a reference to the previous node,
 * and a reference to the next node in the list.
 */
public class DoubleNode {
    int data;
    DoubleNode prev;
    DoubleNode next;

    DoubleNode(int data) {
        this.data = data;
    }
}
