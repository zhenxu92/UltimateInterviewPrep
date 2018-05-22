public class OneEditDistance {
    public static void main(String args[]) {
        String s1 = "ab";
        String s2 = "acb"; 
        System.out.println(isOneEditDistance(s1, s2));  
    }
    
    public static boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m == n) {
            for (int i = 0; i < m; i++) {
                if (s.charAt(i) == t.charAt(i)) continue;
                return s.substring(i + 1).equals(t.substring(i + 1)); 
            }
        }
        
        if (m > n) {
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == t.charAt(i)) continue;
                return s.substring(i + 1).equals(t.substring(i));
            }
            
        } else {
            for (int i = 0; i < m; i++) {
                if (s.charAt(i) == t.charAt(i)) continue;
                return t.substring(i + 1).equals(s.substring(i));
            }
        }
        return Math.abs(m - n) == 1;
    }
}   