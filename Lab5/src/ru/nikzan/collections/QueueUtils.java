package ru.nikzan.collections;

import java.util.Queue;
import java.util.Stack;

public class QueueUtils {
    public static <T> void reverseQueue(Queue<T> l1, Queue<T> l2) {
        Stack<T> stack = new Stack<>();
        while (!l1.isEmpty()) {
            stack.push(l1.poll());
        }
        while (!stack.isEmpty()) {
            l2.add(stack.pop());
        }
    }
}
