import java.util.*;
public class IsAnagram {
    public static void main(String args[]) {
        String a = "abscasdf";
        String b = "bsaacsdf";
        System.out.println(isAnagram(a, b));
    }
    
    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        String strA = new String(arrA);
        String strB = new String(arrB);
        return strA.equals(strB);
    }
}