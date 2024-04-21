import edu.astanait.datastructures.MyStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackTests {
    private MyStack<Integer> stack;

    @BeforeEach
    public void setUp() {
        stack = new MyStack<>();
    }

    @Test
    public void testPush() {
        stack.push(10);
        assertFalse(stack.isEmpty(), "Stack should not be empty after push");
        assertEquals(10, (int)stack.peek(), "Peek should return the last pushed item");
    }

    @Test
    public void testPop() {
        stack.push(10);
        stack.push(20);
        int popped = stack.pop();
        assertEquals(20, popped, "Pop should return the last item pushed");
        assertEquals(1, stack.size(), "Size should decrease by 1 after pop");
    }

    @Test
    public void testPeek() {
        stack.push(10);
        stack.push(20);
        int topItem = stack.peek();
        assertEquals(20, topItem, "Peek should return the last item pushed but not remove it");
        assertEquals(2, stack.size(), "Peek should not change the size of the stack");
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty(), "New stack should be empty");
        stack.push(10);
        assertFalse(stack.isEmpty(), "Stack should not be empty after pushing an item");
        stack.pop();
        assertTrue(stack.isEmpty(), "Stack should be empty after popping the only item");
    }

    @Test
    public void testSize() {
        assertEquals(0, stack.size(), "New stack should have size 0");
        stack.push(10);
        stack.push(20);
        assertEquals(2, stack.size(), "Size should reflect the number of items pushed");
    }

    @Test
    public void testPopOnEmptyStack() {
        assertThrows(NoSuchElementException.class, stack::pop, "Pop on an empty stack should throw NoSuchElementException");
    }

    @Test
    public void testPeekOnEmptyStack() {
        assertThrows(NoSuchElementException.class, stack::peek, "Peek on an empty stack should throw NoSuchElementException");
    }
}
