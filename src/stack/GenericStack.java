package stack;

import java.util.*;

public class GenericStack<E> implements Stack<E> {
    private static final int SIZE = 5;
    private static final String OVER_FLOW = "stack over flow!";
    private static final String EMPTY = "empty stack!";

    private Queue<E> list = new LinkedList<>();
    private int elementsCount;

    @Override
    public void push(E element) throws StackException {
        if (elementsCount >= SIZE) {
            throw new StackException(OVER_FLOW);
        }

        elementsCount++;
        list.add(element);
    }

    @Override
    public E pop() throws StackException {
        E result = list.poll();
        if (result == null) {
            throw new StackException(EMPTY);
        }

        return result;
    }

    @Override
    public E peek() {
        return list.peek();
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean isFull() {
        return elementsCount >= SIZE;
    }

    @Override
    public void pushAll(Collection<? extends E> src) throws StackException {
        for (E element : src) {
            push(element);
        }
    }

    @Override
    public void popAll(Collection<? super E> dst) throws StackException {
        while (!isEmpty()) {
            dst.add(pop());
        }
    }
}
