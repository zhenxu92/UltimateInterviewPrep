import java.util.*;
public class AssignCookies {
    public static void main (String args[]) {
        int[] g = {10, 9, 8, 7};
        int[] s = {10, 9, 8, 7};
        int result = findContentChildren(g, s);
        System.out.println(result);
        
    }
    public static int findContentChildren(int[] g, int[] s) {
        // This problem can be simplified. G is a set a numbers,
        // S is another set of number. The problem is to find the
        // maximum matches between two sets. If a number from set S
        // is bigger than a number from set G, then there is a match
        // in order to have maximum matches, we need to match match s
        // with the smallest g first. So we need to sort this two arrays
        // first. Once there is a match, two elements should be removed
        //
        // To sort these two arrays, I would use Arrays.sort(array). 
        // Another problem to address is that the size of the each array.
        // If matches is equal to the size of any array, the search should
        // be stopped, otherwise just keep searching until it is over.
        
        // Sort arrays.
        Arrays.sort(g);
        Arrays.sort(s);
        List<Integer> k = new ArrayList<Integer>();
        List<Integer> c = new ArrayList<Integer>();
        for (int i = 0; i < g.length; i++) {
            k.add(g[i]);    
        }
        for (int i = 0; i < s.length; i++) {
            c.add(s[i]);    
        }
        int matches = 0;
        int i = 0;
        int j = 0;
        while (!c.isEmpty() && !k.isEmpty() && i != k.size() && j != c.size()) {
            
        }
        return matches;
    }
}