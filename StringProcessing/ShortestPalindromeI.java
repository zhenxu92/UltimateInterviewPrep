public class ShortestPalindromeI {
    public static void main(String args[]) {
        String s = "abcd";
        System.out.println(shortestPalindrome(s));
    }
    
    private static String shortestPalindrome(String s) {
        int max = 0;
        int len = s.length();
        for (int i = 1; i <= len / 2; i++) {
            StringBuilder left = new StringBuilder(s.substring(0, i));
            StringBuilder right = new StringBuilder(s.substring(i, i * 2));
            right.reverse();
            if (left.toString().equals(right.toString())) max = i * 2;
            if (i * 2 + 1 <= len) {
                StringBuilder oddRight = new StringBuilder(s.substring(i + 1, i * 2 + 1));
                oddRight.reverse();
                if (left.toString().equals(oddRight.toString())) max = i * 2 + 1;
            }   
        }
        System.out.println(max);
        StringBuilder sb = new StringBuilder(s.substring(max, len)).reverse();
        sb.append(s);
        return sb.toString();
    }
}