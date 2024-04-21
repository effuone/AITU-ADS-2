package edu.astanait.datastructures;

import java.util.NoSuchElementException;

public class MyQueue<T extends Comparable<T>> {
    private final MyLinkedList<T> list = new MyLinkedList<T>(); // Use MyLinkedList to handle the elements

    // Enqueue an element at the end of the queue
    public void enqueue(T element) {
        list.addLast(element);
    }

    // Dequeue an element from the front of the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T element = list.getFirst(); // Get the first element
        list.removeFirst();           // Remove the first element
        return element;
    }

    // Peek at the front element of the queue without removing it
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return list.getFirst();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return list.size() == 0;
    }

    // Get the size of the queue
    public int size() {
        return list.size();
    }
}
