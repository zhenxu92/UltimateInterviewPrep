import java.util.*;
// The e1 > e2 does not work
public class testEdgeComparator {
    public static void main(String args[]) {
        Vertex one = new Vertex("1", "one");
        Vertex two = new Vertex("2", "two");
        Edge e1 = new Edge("1", one, two, 3);
        Edge e2 = new Edge("2", two, one, 4);
        if(e1.compareTo(e2) > 0) {
            System.out.println( 1);
        } else {
            System.out.println(2);
        }
    }
}