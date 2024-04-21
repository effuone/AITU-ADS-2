import edu.astanait.datastructures.MyQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class MyQueueTests {
    private MyQueue<Integer> queue;

    @BeforeEach
    public void setUp() {
        queue = new MyQueue<>();
    }

    @Test
    public void testEnqueue() {
        queue.enqueue(10);
        assertFalse(queue.isEmpty(), "Queue should not be empty after enqueue");
        assertEquals(1, queue.size(), "Queue size should be 1 after one enqueue");
    }

    @Test
    public void testDequeue() {
        queue.enqueue(10);
        queue.enqueue(20);
        int dequeued = queue.dequeue();
        assertEquals(10, dequeued, "Dequeue should return the first element enqueued");
        assertEquals(1, queue.size(), "Queue size should decrease by 1 after dequeue");
        assertEquals(20, queue.peek(), "Peek should now return the second enqueued element");
    }

    @Test
    public void testPeek() {
        queue.enqueue(10);
        queue.enqueue(20);
        int front = queue.peek();
        assertEquals(10, front, "Peek should return the first element without removing it");
        assertEquals(2, queue.size(), "Peek should not change the queue size");
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty(), "New queue should be empty");
        queue.enqueue(10);
        assertFalse(queue.isEmpty(), "Queue should not be empty after enqueue");
        queue.dequeue();
        assertTrue(queue.isEmpty(), "Queue should be empty after dequeuing the only element");
    }

    @Test
    public void testSize() {
        assertEquals(0, queue.size(), "New queue should have size 0");
        queue.enqueue(10);
        queue.enqueue(20);
        assertEquals(2, queue.size(), "Queue size should reflect the number of items enqueued");
    }

    @Test
    public void testDequeueOnEmptyQueue() {
        assertThrows(NoSuchElementException.class, queue::dequeue, "Dequeue on an empty queue should throw NoSuchElementException");
    }

    @Test
    public void testPeekOnEmptyQueue() {
        assertThrows(NoSuchElementException.class, queue::peek, "Peek on an empty queue should throw NoSuchElementException");
    }
}
