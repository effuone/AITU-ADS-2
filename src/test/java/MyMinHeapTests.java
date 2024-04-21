import edu.astanait.datastructures.MyMinHeap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class MyMinHeapTests {
    private MyMinHeap<Integer> minHeap;

    @BeforeEach
    public void setUp() {
        minHeap = new MyMinHeap<>();
    }

    @Test
    public void testAddAndPeek() {
        minHeap.add(10);
        assertEquals(10, (int) minHeap.peek(), "Peek should return the smallest element");
        minHeap.add(5);
        assertEquals(5, (int) minHeap.peek(), "Peek should now return the new smallest element");
    }

    @Test
    public void testExtractMin() {
        minHeap.add(5);
        minHeap.add(10);
        assertEquals(5, (int) minHeap.extractMin(), "ExtractMin should return the smallest element");
        assertEquals(10, (int) minHeap.peek(), "Peek should return the next smallest element after extraction");
        assertEquals(10, (int) minHeap.extractMin(), "ExtractMin should return the last element");
        assertTrue(minHeap.isEmpty(), "Heap should be empty after removing all elements");
    }

    @Test
    public void testHeapProperty() {
        minHeap.add(50);
        minHeap.add(30);
        minHeap.add(20);
        minHeap.add(15);
        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(1);
        assertEquals(1, (int) minHeap.extractMin(), "ExtractMin should always return the smallest element");
        assertEquals(5, (int) minHeap.extractMin(), "Followed by the next smallest element");
        assertEquals(10, (int) minHeap.extractMin(), "Continuing with the heap property in order");
    }

    @Test
    public void testSize() {
        assertEquals(0, minHeap.size(), "Initial size should be 0");
        minHeap.add(5);
        minHeap.add(10);
        assertEquals(2, minHeap.size(), "Size should reflect number of items added");
    }

    @Test
    public void testIsEmpty() {
        assertTrue(minHeap.isEmpty(), "Heap should initially be empty");
        minHeap.add(10);
        assertFalse(minHeap.isEmpty(), "Heap should not be empty after adding elements");
        minHeap.extractMin();
        assertTrue(minHeap.isEmpty(), "Heap should be empty after removing all elements");
    }

    @Test
    public void testPeekOnEmptyHeap() {
        assertThrows(NoSuchElementException.class, minHeap::peek, "Peek on an empty heap should throw NoSuchElementException");
    }

    @Test
    public void testExtractMinOnEmptyHeap() {
        assertThrows(NoSuchElementException.class, minHeap::extractMin, "ExtractMin on an empty heap should throw NoSuchElementException");
    }
}
