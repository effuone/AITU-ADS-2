# AITU Algorithms and Data Structures Homework 2

## Overview
This DSA homework repository consists of custom implementations of several fundamental data structures in Java. The implementations include `MyArrayList` and `MyLinkedList`, which are custom versions of `ArrayList` and `LinkedList` respectively, and `MyStack`, `MyQueue`, and `MyMinHeap` which are based on `MyArrayList` and `MyLinkedList`.

## Data Structures Implemented
- **MyArrayList**: A dynamic array implementation of the `MyList` interface.
- **MyLinkedList**: A doubly linked list implementation of the `MyList` interface.
- **MyStack**: A LIFO (last in, first out) data structure.
- **MyQueue**: A FIFO (first in, first out) data structure.
- **MyMinHeap**: A specialized tree-based data structure that satisfies the heap property.

## Project Setup
The project is structured as a Maven build type and includes a series of JUnit tests to validate the functionality of each implemented data structure.

### Directory Structure
- `src/main/java/edu.astanait/datastructures`: Contains all the physical data structures and related things (e.g MyList interface).
- `src/test/java/`: Contains all the JUnit test classes.

## Dependencies
- Java JDK (Java 8 or above)
- Maven (For dependency management and running the project)

## Configurations
The project configurations are managed through the `.idea` folder, ensuring the settings are consistent for IntelliJ IDEA users. I recommend you to use my config settings, so that you can run tests just by clicking `Shift + F10`

## Running Tests
To see how to use these data structures, you can run the provided JUnit tests. Follow these instructions to run the tests within IntelliJ IDEA:

1. **Open Project**: Start IntelliJ IDEA and open the project by selecting the project directory.
2. **Import as Maven Project**: Ensure that the project is recognized as a Maven project. If not, you can import it by selecting `Import Project` and following the prompts to use Maven's project settings.
3. **Run Tests**:
    - To run all tests, right-click on the `src/test/java` directory and select `Run 'All Tests'`.
    - To run individual tests, navigate to a specific test class, right-click, and select `Run '<test class name>'`.

## Implementation Details
Each class is documented to explain how the specific data structure is implemented using `MyArrayList` or `MyLinkedList` as the underlying data structure. Consideration was given to the most suitable physical data structure for each logical data structure based on their typical use cases and operations.

## Time and space complexity comparison table
| Data Structure | Operation   | Time Complexity | Space Complexity |
|----------------|-------------|-----------------|------------------|
| MyArrayList    | Add         | O(1) amortized  | O(n)             |
|                | Get         | O(1)            | O(1)             |
|                | Remove      | O(n)            | O(1)             |
|                | Set         | O(1)            | O(1)             |
| MyLinkedList   | Add         | O(1) at ends    | O(1)             |
|                | Get         | O(n)            | O(1)             |
|                | Remove      | O(1) at ends    | O(1)             |
|                | Set         | O(n)            | O(1)             |
| MyStack        | Push        | O(1)            | O(1)             |
|                | Pop         | O(1)            | O(1)             |
|                | Peek        | O(1)            | O(1)             |
| MyQueue        | Enqueue     | O(1)            | O(1)             |
|                | Dequeue     | O(1)            | O(1)             |
|                | Peek        | O(1)            | O(1)             |
| MyMinHeap      | Add         | O(log n)        | O(1)             |
|                | Extract Min | O(log n)        | O(1)             |
|                | Peek        | O(1)            | O(1)             |

## General explanatory notes
1. **Amortized Time Complexity for MyArrayList Add**: This is noted as amortized because while most additions are O(1), occasionally (when the underlying array needs to be resized) the cost is O(n), and this cost is spread out over many operations.
2. **LinkedList Operations at Ends**: Operations like add/remove at the ends of a linked list are O(1) because they only involve updating a few pointers. For operations at specific indices (not at ends), the complexity becomes O(n) because it may require traversing the list from the start to the index.
3. **Stack and Queue**: All primary operations are O(1) because they deal with elements only at one end or both ends without intermediate traversal.
4. **MinHeap Operations**: Adding and removing elements (extract min) have a logarithmic complexity due to the heapify process that maintains the heap structure