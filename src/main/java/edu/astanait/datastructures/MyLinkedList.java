package edu.astanait.datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
        // If the list is empty, add the new node as the head and tail.
        if (head == null) {
            head = new ListNode<>(item);
            tail = head;
        } else {
            // Otherwise, add the new node after the tail and update the tail reference.
            ListNode<T> newNode = new ListNode<>(item, null, tail);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void set(int index, T item) {

    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        // If adding at the start, use addFirst method.
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            // If adding at the end, use addLast method.
            addLast(item);
        } else {
            // Otherwise, find the node currently at the specified index.
            ListNode<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            // Create a new node and re-link the references.
            ListNode<T> newNode = new ListNode<>(item, current, current.prev);
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    @Override
    public void addFirst(T item) {
        // Create a new node that points to the current head.
        ListNode<T> newNode = new ListNode<>(item, head, null);
        // If the list is empty, head and tail should both point to the new node.
        if (head == null) {
            tail = newNode;
        } else {
            // Otherwise, update the previous head to point back to the new node.
            head.prev = newNode;
        }
        head = newNode;
        size++;
    }

    @Override
    public void addLast(T item) {
        // This method is the same as the add method which adds the item at the end.
        add(item);
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
        // If the list is empty, throw an exception
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.data; // Return the data of the first node
    }

    @Override
    public T getLast() {
        // If the list is empty, throw an exception
        if (tail == null) {
            throw new NoSuchElementException();
        }
        return tail.data; // Return the data of the last node
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        // Special cases: remove first or last
        if (index == 0) {
            removeFirst();
            return;
        } else if (index == size - 1) {
            removeLast();
            return;
        }

        // Find the node to remove
        ListNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        // Unlink the node from the list
        current.prev.next = current.next;
        current.next.prev = current.prev;
        current.next = null; // Help garbage collection
        current.prev = null; // Help garbage collection

        size--;
    }

    @Override
    public void removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        // Move the head pointer to the next node, which will become the new head
        ListNode<T> nextNode = head.next;

        if (nextNode != null) {
            // If there's a next node, update its prev pointer to null
            nextNode.prev = null;
        } else {
            // If there's no next node, the list is now empty and tail should also be null
            tail = null;
        }

        // Help garbage collection
        head.next = null;
        head = nextNode;

        size--;
    }

    @Override
    public void removeLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }

        // Move the tail pointer to the previous node, which will become the new tail
        ListNode<T> prevNode = tail.prev;

        if (prevNode != null) {
            // If there's a previous node, update its next pointer to null
            prevNode.next = null;
        } else {
            // If there's no previous node, the list is now empty and head should also be null
            head = null;
        }

        // Help garbage collection
        tail.prev = null;
        tail = prevNode;

        size--;
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
