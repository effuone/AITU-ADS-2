import edu.astanait.datastructures.MyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class MyLinkedListTest {
    private MyLinkedList<Integer> list;

    @BeforeEach
    public void setUp() {
        list = new MyLinkedList<>();
    }

    @Test
    public void testAddAndGet() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(10, (int) list.get(0));
        assertEquals(20, (int) list.get(1));
        assertEquals(30, (int) list.get(2));
    }

    @Test
    public void testAddAtIndex() {
        list.add(10);
        list.add(20);
        list.add(1, 15);
        assertEquals(15, (int) list.get(1));
        assertEquals(20, (int) list.get(2));
        assertEquals(3, list.size());
    }

    @Test
    public void testRemove() {
        list.add(10);
        list.add(20);
        list.remove(0);
        assertEquals(20, (int) list.get(0));
        assertEquals(1, list.size());
    }

    @Test
    public void testSet() {
        list.add(10);
        list.set(0, 100);
        assertEquals(100, (int) list.get(0));
    }

    @Test
    public void testClear() {
        list.add(10);
        list.add(20);
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testSize() {
        assertEquals(0, list.size());
        list.add(10);
        list.add(20);
        assertEquals(2, list.size());
    }

    @Test
    public void testIndexOutOfBoundsExceptionForAdd() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(3, 10));
    }

    @Test
    public void testIndexOutOfBoundsExceptionForGet() {
        list.add(10);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Test
    public void testIndexOutOfBoundsExceptionForSet() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, 10));
    }

    @Test
    public void testIndexOutOfBoundsExceptionForRemove() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    public void testIterator() {
        list.add(10);
        list.add(20);
        Iterator<Integer> it = list.iterator();
        assertTrue(it.hasNext());
        assertEquals(10, (int) it.next());
        assertEquals(20, (int) it.next());
        assertFalse(it.hasNext());
    }

    @Test
    public void testSort() {
        list.add(30);
        list.add(10);
        list.add(20);
        list.add(40);
        list.add(50);
        list.sort();
        assertEquals(10, (int) list.get(0));
        assertEquals(20, (int) list.get(1));
        assertEquals(30, (int) list.get(2));
        assertEquals(40, (int) list.get(3));
        assertEquals(50, (int) list.get(4));
    }

    @Test
    public void testAddFirstAndLast() {
        list.addFirst(10);
        list.addLast(20);
        assertEquals(10, (int) list.getFirst());
        assertEquals(20, (int) list.getLast());
    }

    @Test
    public void testRemoveFirstAndLast() {
        list.add(10);
        list.add(20);
        list.removeFirst();
        assertEquals(20, (int) list.getFirst());
        list.removeLast();
        assertEquals(0, list.size());
    }
}
