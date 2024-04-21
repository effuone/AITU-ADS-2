package edu.astanait.datastructures;

import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private T[] array; // Internal array to hold the list elements.
    private int size; // The number of elements currently in the list.

    // Default constructor that initializes the list with an initial capacity of 10.
    public MyArrayList() {
        array = (T[]) new Object[10];
        size = 0;
    }

    // Constructor with specified initial capacity; throws IllegalArgumentException if capacity is negative.
    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        array = (T[]) new Object[initialCapacity];
        size = 0;
    }

    // Constructor that initializes the list with an existing array of items.
    public MyArrayList(T[] items) {
        array = items;
        size = items.length;
    }

    // Copy constructor that initializes the list with another MyArrayList instance.
    public MyArrayList(MyArrayList<T> list) {
        array = list.array;
        size = list.size;
    }

    // Add the given item to the end of the list. Expands the array if necessary.
    @Override
    public void add(T item) {
        // If the array is full, double its size.
        if (size == array.length) {
            T[] newArray = (T[]) new Object[array.length * 2];
            // Copy the elements to the new array.
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        // Add the new item and increment the size.
        array[size] = item;
        size++;
    }

    // Set the item at the given index to the given value. Throws IndexOutOfBoundsException if index is out of bounds.
    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = item;
    }

    // Add the given item at the given index. Shifts subsequent elements to the right. Expands the array if necessary.
    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        // Resize the array if it is full.
        if (size == array.length) {
            T[] newArray = (T[]) new Object[array.length * 2];
            // Use System.arraycopy for better performance when copying elements.
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        // Shift elements to the right to make room for the new element.
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        size++;
    }

    // Convenience method to add an item at the start of the list.
    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    // Convenience method to add an item at the end of the list (same as add(T item)).
    @Override
    public void addLast(T item) {
        add(item);
    }

    // Get the item at the given index. Throws IndexOutOfBoundsException if index is out of bounds.
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    // Get the first item in the list. Throws IndexOutOfBoundsException if the list is empty.
    @Override
    public T getFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        return array[0];
    }

    // Get the last item in the list. Throws IndexOutOfBoundsException if the list is empty.
    @Override
    public T getLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        return array[size - 1];
    }

    // Remove the item at the start of the list. Throws IndexOutOfBoundsException if the list is empty.
    @Override
    public void removeFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        // Shift elements to the left to fill the gap left by the removed element.
        for (int i = 0; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    // Remove the item at the given index. Throws IndexOutOfBoundsException if index is out of bounds.
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        // Shift elements to the left to fill the gap left by the removed element.
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    // Remove the last item in the list. Throws IndexOutOfBoundsException if the list is empty.
    @Override
    public void removeLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        // Simply decrement the size, effectively removing the last item.
        size--;
    }

    // Sorts the list using a bubble sort algorithm. Assumes T implements Comparable<T>.
    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                // If the current element is greater than the next, swap them.
                if (((Comparable<T>) array[i]).compareTo(array[j]) > 0) {
                    T temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    // Return the index of the first occurrence of the specified object or -1 if not found.
    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    // Return the index of the last occurrence of the specified object or -1 if not found.
    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    // Check if the list contains the specified object.
    @Override
    public boolean exists(Object object) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(object)) {
                return true;
            }
        }
        return false;
    }

    // Return an array containing all elements in the list.
    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        // Use System.arraycopy for better performance when copying elements.
        System.arraycopy(array, 0, arr, 0, size);
        return arr;
    }

    // Empty the list.
    @Override
    public void clear() {
        size = 0; // Simply reset the size to 0 to clear the list.
    }

    // Get the number of items in the list.
    @Override
    public int size() {
        return size;
    }

    // Provide an iterator over the elements in the list.
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0; // Current position in the iteration.

            @Override
            public boolean hasNext() {
                return index < size; // Check if more elements are available.
            }

            @Override
            public T next() {
                return array[index++]; // Return the next element and increment the index.
            }
        };
    }

}
