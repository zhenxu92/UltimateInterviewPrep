/**
 * Minimum Spanning Tree Kruskal Algorithm  v 1.0
 * @author zhenxu
 *
 * This program use Kruskal Algorithm to find the minimum
 * spanning tree in a graph. The algorithm is pretty straightforward
 * in that it just sort the edges by weight, then choose from the lowest
 * weighted edges, put it in the tree and check if there is a circle using 
 * union-find structure.
 */
import java.util.*;
public class KMSP {
	private List<Edge> edges;
	private Queue<Edge> mst;
	
	public KMSP (Graph graph) {
		mst = new LinkedList<Edge>();
		HeapSort hs = new HeapSort();
		this.edges = graph.getEdges();
		for(Edge e : edges) {
			hs.insert(e);
		}
		
		UnionFind uf = new UnionFind(graph.getVertexes().size() + 1);
		while(!hs.isEmpty() && mst.size() < graph.getVertexes().size() - 1) {
			Edge e = hs.deleteMin();
			int source = e.getSource().getId();
			int destination = e.getDestination().getId();
			if(!uf.connected(source, destination)) {
				uf.union(source, destination);
				mst.add(e);
			}
		}
		
	}
	
	public Queue<Edge> edges() {
		return mst;
	}
	
	public static void main(String args[]) {
		Graph g = new Graph();
		Vertex v1 = new Vertex(1, "one", 2, 1);
		Vertex v2 = new Vertex(2, "two", 3, 6);
		Vertex v3 = new Vertex(3, "three", 3, 7);
		Vertex v4 = new Vertex(4, "four", 4, 1);
		Vertex v5 = new Vertex(5, "five", 6, 3);
		Vertex v6 = new Vertex(6, "six", 7, 4);
		List<Vertex> vertices = new ArrayList<Vertex>();
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		vertices.add(v4);
		vertices.add(v5);
		vertices.add(v6);
		int num = 0;
		for (int i = 0; i < vertices.size(); i++) {
			for (int j = 0; j < vertices.size(); j++) {
				if(i != j) {
					Edge e = new Edge(num, vertices.get(i), vertices.get(j));
					num++;
					g.addEdge(e);
				}
			}
		}
		KMSP kmsp = new KMSP(g);
        Queue<Edge> mst = kmsp.edges();
        while(!mst.isEmpty()) {
            System.out.println(mst.remove().toString());
        }
		
	}
	
	
}
