import java.util.*;
public class MergeIntervals {
    public static void main(String args[]) {
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(1, 5));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        intervals.add(new Interval(20, 21));
        List<Interval> res = merge(intervals);
        for (Interval i : res) {
            System.out.print("[" + i.start + ", " + i.end + "] ");
        }
    }
    
    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) return intervals;
        List<Interval> res = new LinkedList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        
        for (Interval i : intervals) {
            pq.add(i);
        }   
        Stack<Interval> stack = new Stack<>();
        stack.push(pq.remove());
        while (!stack.isEmpty() && !pq.isEmpty()) {
            Interval cur = stack.pop();
            Interval next = pq.remove();
            // overlapping
            if (cur.end >= next.start) {
                Interval mg = new Interval(cur.start, next.end);
                stack.push(mg);
            // not overlapping
            } else {
                stack.push(cur);
                stack.push(next);
            }
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        Collections.reverse(res);
        return res;
    }
}