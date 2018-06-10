import java.util.*;
public class NextGreaterIII {
    public static void main(String args[]) {
        int n = 12443322;
        System.out.println(nextGreaterElement(n));
    }
    public static int nextGreaterElement(int n) {
        if (n <= 0) return -1;
        // find the first digit that is smaller than the current right most digit
        Integer num = new Integer(n);
        String s = num.toString();
        char[] seq = s.toCharArray();
        int i = seq.length - 1;
        while (i > 0) {
            if (seq[i - 1] < seq[i]) break;
            i--;
        }

        if (i <= 0) return -1;
        i = i - 1;
        // found first smaller
        System.out.println("first smaller: " + seq[i]);
        int j = i + 1;
        while (j < seq.length) {
            if (seq[j] <= seq[i]) break;
            j++;
        }
        j = j - 1;
        // found pivot
        swap(seq, i, j);
        reverse(seq, i + 1);
        try {
            return Integer.parseInt(new String(seq));            
        } catch (Exception ex) {
            return -1;
        }
        
    }
    
    private static void swap(char[] seq, int i, int j) {
        char tp = seq[i];
        seq[i] = seq[j];
        seq[j] = tp;
        return;
    }
    
    private static void reverse(char[] seq, int i) {
        int lo = i;
        int hi = seq.length - 1;
        while (lo < hi) {
            char tp = seq[lo];
            seq[lo] = seq[hi];
            seq[hi] = tp;
            lo++;
            hi--;
        }
        return;
    }
}