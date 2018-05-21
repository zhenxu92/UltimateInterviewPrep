public class ObjectHeapSortClient {
    public static void main(String args[]) {
        Vertex one = new Vertex("1", "one");
        Vertex two = new Vertex("2", "two");
        Vertex three = new Vertex("3", "three");
        Vertex four = new Vertex("4", "four");
        Vertex five = new Vertex("5", "five");
        Vertex six = new Vertex("6", "six");
        Edge e1 = new Edge("1", one, two, 3);
        Edge e2 = new Edge("2", two, one, 4);
        Edge e3 = new Edge("3", three, one, 10);
        Edge e4 = new Edge("4", four, one, 20);
        Edge e5 = new Edge("5", five, one, 1);
        Edge e6 = new Edge("6", six, one, 2);

        ObjectHeapSort ohs = new ObjectHeapSort();
        ohs.insert(e1);
        ohs.insert(e2);
        ohs.insert(e3);
        ohs.insert(e4);
        ohs.insert(e5);
        ohs.insert(e6);
        System.out.println(ohs.deleteMin().toString());
        System.out.println(ohs.deleteMin().toString());
        System.out.println(ohs.deleteMin().toString());
        
    }
}