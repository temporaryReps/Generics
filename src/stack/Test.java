package stack;

import stack.GenericStack;
import stack.StackException;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws StackException {
        GenericStack<Integer> stack = new GenericStack<>();

        stack.isEmpty();
        stack.isFull();

        for (int i = 0; i < 3; i++) {
            stack.push(Integer.valueOf(i));
        }

//        List<Integer> list = new ArrayList<>();
//        list.add(56);
//        list.add(32);
//        stack.pushAll(list);

//        for (int i = 0; i < 4; i++) {
//            stack.peek();
//        }

        stack.isEmpty();
        stack.isFull();

//        for (int i = 0; i < 5; i++) {
//            stack.pop();
//        }

        List<Integer> list1 = new ArrayList<>();
        list1.add(1234);
        list1.add(765);
        list1.add(654);
        stack.popAll(list1);
    }
}
