import java.util.*;
class DecodedStringAtIndex {
    public static void main(String args[]) {
        String s = "appleappleappleappleappleapple";
        System.out.println(decodeAtIndex(s, 24));
    }

    public static String decodeAtIndex(String S, int K) {
        int size = 0;
        int end = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (Character.isDigit(c)) {
                size = size * (c - '0');
            } else {
                size++;
            }
            if (size >= K) {
                end = i;
                break;
            }
        }
        
        for (int i = end; i >= 0; i--) {
            K = K % size;
            if (K == 0 && !Character.isDigit(S.charAt(i))) {
                return "" + S.charAt(i);
            }
            char c = S.charAt(i);
            if (Character.isDigit(c)) {
                size = size / (c - '0');
            } else {
                size--;
            }
            
        }
        return null;
    }
}