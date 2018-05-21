import java.util.*;
public class ReformattingKey {

    public static void main(String args[]) {
        String S = "--a-a-a-a--";
        int K = 2;
        System.out.println(licenseKeyFormatting(S, K));
    }
    
    private static String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int i = S.length() - 1;
        while (i >= 0) {
            int count = 0;
            while (i >= 0 && count < K) {
                char c = S.charAt(i);
                if (Character.isDigit(c) || Character.isAlphabetic(c)) {
                    sb.append(c);
                    count++;
                }
                i--;
            }
            sb.append("-");
        }
        // remove all "-" at the front
        int j = sb.length() - 1;
        while (j >= 0 && sb.charAt(j) == '-') j--;
        sb.setLength(j + 1);
        return sb.reverse().toString().toUpperCase();
    }
}