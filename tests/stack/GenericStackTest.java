package stack;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class GenericStackTest {
    private GenericStack<Object> stack;

    @Before
    public void initStack() {
        stack = new GenericStack<>();
    }

    /**
     * must throw StackException when elements count more than 5
     */
    @Test(expected = StackException.class)
    public void testPushInt() throws StackException {
        Object[] intElements = {0, 1, 2, 3, 4, 5}; // 6 elements
        for (Object element : intElements) {
            stack.push(element);
        }
    }

    @Test(expected = StackException.class)
    public void testPushString() throws StackException {
        Object[] stringElements = {"zero", "one", "two", "three", "four", "five"}; // 6 elements
        for (Object element : stringElements) {
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

        assertEquals("Must return top of stack", 4, stack.pop());
        assertEquals("Must return top of stack", 78, stack.pop());

        assertEquals("Must return top of stack", "four", stack.pop());
        assertEquals("Must return top of stack", "seventy eight", stack.pop());
    }

    /**
     * must return top of stack and don't remove it
     */
    @Test
    public void peek() throws StackException {
        testStackAddElements();

        assertEquals("Must return top of stack", 4, stack.peek());
        assertEquals("Must return top of stack", 4, stack.peek());
    }

    /**
     * must return size of GenericStack
     */
    @Test
    public void getSize() throws StackException {
        testStackAddElements();

        assertEquals("Stack size must be equal 4", 4, stack.getSize());
    }

    private void testStackAddElements() throws StackException {
        stack.push(4);
        stack.push(78);

        stack.push("four");
        stack.push("seventy eight");
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
        stack.push("new element");
        List<Integer> testListInteger = Arrays.asList(67, 432);
        List<String> testListString = Arrays.asList("one", "two");
        stack.pushAll(testListInteger);
        stack.pushAll(testListString);

        assertEquals("new element", stack.pop());
        assertEquals(67, stack.pop());
        assertEquals(432, stack.pop());
        assertEquals("one", stack.pop());
        assertEquals("two", stack.pop());
    }

    /**
     * add elements from stack to dst list
     */
    @Test
    public void popAll() throws StackException {
        GenericStack<Integer> integerStack = createAndFillIntegerStack();

        List<Number> dst = new LinkedList<>();
        dst.add(58.0);
        dst.add(325);
        dst.add(773.433);

        List<Number> testList = Arrays.asList(58.0, 325, 773.433, 0, 11, 22);
        integerStack.popAll(dst);

        assertEquals("Lists must be equal ",
                testList, dst);


        integerStack = createAndFillIntegerStack();

        List<Object> dstObject = new LinkedList<>();
        dstObject.add(58.0);
        dstObject.add("one");
        dstObject.add("two");

        List<Object> testObjectList = Arrays.asList(58.0, "one", "two", 0, 11, 22);
        integerStack.popAll(dstObject);

        assertEquals("Lists must be equal ",
                testObjectList, dstObject);
    }

    private GenericStack<Integer> createAndFillIntegerStack() throws StackException {
        GenericStack<Integer> integerStack = new GenericStack<>();

        for (int i = 0; i < 3; i++) {
            integerStack.push(i * 11);
        }

        return integerStack;
    }
}