public class ValidPalindrome {
    public static void main(String args[]) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
    
    public static boolean isPalindrome(String s) {
        // sc
        if (s == null || s.length() == 0) return true;
        s = s.toLowerCase();
        int lo = 0;
        int hi = s.length() - 1;
        while (lo < hi) {
            if (!Character.isLetterOrDigit(s.charAt(lo))) {
                lo++;
                continue;
            }
            
            if (!Character.isLetterOrDigit(s.charAt(hi))) {
                hi--;
                continue;
            }
            
            if (s.charAt(lo) != s.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true; 
    }
    
}
