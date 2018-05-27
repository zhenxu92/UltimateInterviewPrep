public class AlienDictionary {
    public static void main(String args[]) {
        String[] words = new String[]{
            "wrt", "wrf", "er", "ett", "rftt"
        };
    }
    
    public String alienOrder(String[] words) {
        boolean[][] graph = new boolean[26][26];
        buildGraph(graph, words);
        int[] degree = new int[26];
        
    }
    
    public void indegree(int[] degree, boolean[][] graph) {
        
    }
    
    public void buildGraph(boolean[][] graph, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                char[] first = words[i - 1].toCharArray();
                char[] second = words[i].toCharArray();
                int len = Math.min(first, second);
                for (int j = 0; j < len; j++) {
                    char c1 = first[j];
                    char c2 = second[j];
                    if (c1 != c2) {
                        graph[c1 - 'a'][c2 - 'a'] = true;
                        break;
                    }
                }
            }
        }
    }
}