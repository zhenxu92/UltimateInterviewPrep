import java.util.*;
public class ZigzagIterator {
    Queue<Iterator> q = new LinkedList<>();
    Iterator<Integer> iter;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        if (v1 != null) q.add(v1.iterator());
        if (v2 != null) q.add(v2.iterator());
        this.iter = q.remove();
    }

    public int next() {
        int res = iter.next();
        q.add(iter);
        iter = q.remove();
        return res;
    }

    public boolean hasNext() {
        while (!iter.hasNext()) {
            iter = q.remove();
        }
        return !q.isEmpty();
    }

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
    public static void main(String args[]) {
        List<Integer> v1 = new ArrayList<Integer>();
        List<Integer> v2 = new ArrayList<Integer>();
        v1.add(1);
        v1.add(2);
        v2.add(3);
        v2.add(4);
        v2.add(5);
        v2.add(6);
        ZigzagIterator i = new ZigzagIterator(v1, v2);
        while (i.hasNext()) System.out.print(i.next());
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */