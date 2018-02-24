package stack;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class GenericStackTest {
    private GenericStack<Integer> stack;

    @Before
    public void initStack() {
        stack = new GenericStack<>();
    }

    /**
     * must throw StackException when elements count more than 5
     */
    @Test(expected = StackException.class)
    public void testPush() throws StackException {
        Integer[] elements = {0, 1, 2, 3, 4, 5}; // 6 elements
        for (int element : elements) {
            stack.push(element);
        }
    }

    /**
     * must throw StackException when elements count equal 0
     */
    @Test(expected = StackException.class)
    public void testPop() throws StackException {
        stack.pop();
    }

    /**
     * must return top of stack and remove it
     */
    @Test
    public void testPopTop() throws StackException {
        testStackAddElements();

        assertEquals("Must return top of stack", 4, stack.pop().intValue());
        assertEquals("Must return top of stack", 78, stack.pop().intValue());
    }

    /**
     * must return top of stack and don't remove it
     */
    @Test
    public void peek() throws StackException {
        testStackAddElements();

        assertEquals("Must return top of stack", 4, stack.peek().intValue());
        assertEquals("Must return top of stack", 4, stack.peek().intValue());
    }

    /**
     * must return size of GenericStack
     */
    @Test
    public void getSize() throws StackException {
        testStackAddElements();

        assertEquals("Stack size must be equal 3", 3, stack.getSize());
    }

    private void testStackAddElements() throws StackException {
        stack.push(4);
        stack.push(78);
        stack.push(34);
    }

    /**
     * must return true when GenericStack's is empty
     */
    @Test
    public void isEmpty() {
        assertTrue("Stack mush be empty", stack.isEmpty());
    }

    /**
     * must return true when GenericStack's is full
     */
    @Test
    public void isFull() throws StackException {
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        stack.isFull();
    }

    /**
     * add testList in stack
     *
     * @throws StackException
     */
    @Test
    public void pushAll() throws StackException {
        stack.push(453);
        List<Integer> testList = Arrays.asList(67, 23, 432);
        stack.pushAll(testList);

        assertEquals(453, stack.pop().intValue());
        assertEquals(67, stack.pop().intValue());
        assertEquals(23, stack.pop().intValue());
        assertEquals(432, stack.pop().intValue());
    }

    /**
     * add elements from stack to dst list
     */
    @Test
    public void popAll() throws StackException {
        for (int i = 0; i < 3; i++) {
            stack.push(i * 11);
        }

        List<Number> dst = new LinkedList<>();
        dst.add(58.0);
        dst.add(325);
        dst.add(773.433);

        List<Number> testLIst = Arrays.asList(58.0, 325, 773.433, 0, 11, 22);
        stack.popAll(dst);

        assertEquals("Lists must be equal ",
                testLIst, dst);
    }
}