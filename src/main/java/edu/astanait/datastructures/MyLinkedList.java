package edu.astanait.datastructures;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private static class ListNode<T> {
        T data;          // Data for the node
        ListNode<T> next;     // Reference to the next node in the list
        ListNode<T> prev;     // Reference to the previous node in the list

        // Constructor to create a new node with data and no next or previous node (end of list)
        ListNode(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        // Constructor to create a new node with data and references to next and previous nodes
        ListNode(T data, ListNode<T> next, ListNode<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private ListNode<T> head;
    private ListNode<T> tail;
    private int size;

    @Override
    public void add(T item) {

    }

    @Override
    public void set(int index, T item) {

    }

    @Override
    public void add(int index, T item) {

    }

    @Override
    public void addFirst(T item) {

    }

    @Override
    public void addLast(T item) {

    }

    @Override
    public T get(int index) {
        // Check for a valid index
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        ListNode<T> current;
        // If the index is in the first half of the list, start from the head
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next; // Move to the next node
            }
        } else {
            // If the index is in the second half of the list, start from the tail
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev; // Move to the previous node
            }
        }
        return current.data;
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object object) {
        return 0;
    }

    @Override
    public boolean exists(Object object) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}