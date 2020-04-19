import java.util.Deque;
import java.util.LinkedList;

public class MyDeque {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.addLast("D");
        deque.addLast("E");
        deque.addFirst("Q");

        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());
    }
}