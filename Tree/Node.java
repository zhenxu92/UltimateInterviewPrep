public class Node {
    public int cost;
    public Node[] children;
    public Node parent;
    
    public Node(int cost) {
        this.cost = cost;
        children = null;
        parent = null;
    }
}