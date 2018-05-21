import java.util.*;
public class ZigzagIterator {
    Queue<Integer> q;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        q = new LinkedList<Integer>();
        int i = 0;
        int j = 0;
        while (i < v1.size() || j < v2.size()) {
            if (i < v1.size()) {
                q.offer(v1.get(i));
                i++;
            }
            
            if (j < v2.size()) {
                q.offer(v2.get(j));
                j++;
            }
        }
    }

    public int next() {
        return q.poll();
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }
    
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