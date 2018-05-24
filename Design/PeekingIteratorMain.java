import java.util.*;
public class PeekingIteratorMain {
    public static void main(String args[]) {
        // 1 2 3 4
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        PeekingIterator pi = new PeekingIterator(list.iterator());
        System.out.println(pi.hasNext());
        System.out.println(pi.peek());
        System.out.println(pi.peek());
        System.out.println(pi.next());
        System.out.println(pi.next());
        System.out.println(pi.peek());
        System.out.println(pi.peek());
        System.out.println(pi.next());
        System.out.println(pi.hasNext());
        System.out.println(pi.peek());
        System.out.println(pi.hasNext());
        System.out.println(pi.next());
        System.out.println(pi.hasNext());
    }
}