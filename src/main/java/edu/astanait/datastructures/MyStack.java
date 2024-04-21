package edu.astanait.datastructures;

import java.util.NoSuchElementException;

public class MyStack<T extends Comparable<T>> {
    private MyLinkedList<T> list = new MyLinkedList<T>();

    // Push an element onto the stack
    public void push(T element) {
        list.addLast(element);  // Elements are added to the end for LIFO
    }

    // Pop the top element from the stack
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T element = list.getLast();  // Get the last element
        list.removeLast();           // Remove the last element
        return element;
    }

    // Peek at the top element of the stack without removing it
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return list.getLast();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return list.size() == 0;
    }

    // Get the size of the stack
    public int size() {
        return list.size();
    }
}
