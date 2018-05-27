public class isPalindromeInteger{
    public static void main(String args[]) {
        int n = 202;
        System.out.println(isPalindrome(n));
    }
    
    public static boolean isPalindrome(int n) {
        int tp = n;
        int res = 0;
        while (tp > 0) {
            // get digit
            int digit = tp % 10;
            res = res * 10 + digit;
            tp = tp / 10;
        }
        return res == n;
    }
}