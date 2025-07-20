package com.vcarrin87.linked_list;

/**
 * A SingleNode represents a single SingleNode in a singly linked list.
 * Each SingleNode contains data and a reference to the next SingleNode in the list.
 */
public class SingleNode {
    public int data;
    public SingleNode next;

    public SingleNode(int data) {
        this.data = data;
        this.next = null;
    }
}
