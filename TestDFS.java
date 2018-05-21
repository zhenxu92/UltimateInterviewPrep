import java.util.*;

public class TestDFS {
    public static void main(String[] args) {
        List<Integer>[] g = new List[5];
        for (int i = 0; i < g.length; i++)
          g[i] = new ArrayList<>();
        
        g[2].add(3);
        g[0].add(1);
        g[0].add(3);
        g[0].add(4);
        g[1].add(3);
        g[3].add(0);
    
        List<List<Integer>> components = scc(g);
        System.out.println(components);
  }
}