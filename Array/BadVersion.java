public class BadVersion {
    public static void main(String args[]) {
        int n = 2;
        helper(1, n);    
    }

    public static int helper(int lo, int hi) {
        int mid = (lo + hi) / 2;
        if (isBadVersion(mid)) {
            return mid;
        } else {
            return helper(mid + 1, hi);
        }
    }
    
    public static boolean isBadVersion(int v) {
        if (v == 1) return true;
        return false;
    }
    
    
}