package Demo;

import java.util.ArrayDeque;
import java.util.Deque;

public class DemoStackAndQueue {
    public static void main(String[] args) {
        // Thêm vào cuối, lấy ở cuối ---> Stack
        System.out.println("Stack: ");
        Deque<String> stack = new ArrayDeque<>();
        stack.addLast("A");
        stack.addLast("B");
        stack.addLast("C");
        stack.addLast("D");
        while (!stack.isEmpty()) {
            System.out.println(stack.pollLast());
        }
        // Thêm vào cuối, lấy ở đầu ---> Queue

        Deque<String> queue = new ArrayDeque<>();
        System.out.println("Queue: ");
        queue.addLast("A");
        queue.addLast("B");
        queue.addLast("C");
        queue.addLast("D");
        while (!queue.isEmpty()) {
            System.out.println(queue.pollFirst());
        }
    }
}
