package com.vcarrin87.linked_list;

/**
 * A CircularNode represents a single node in a circular linked list.
 * Each CircularNode contains data and a reference to the next node in the list.
 */
public class CircularNode {
    int data;
    CircularNode next;

    CircularNode(int data) {
        this.data = data;
        this.next = null;
    }
}
