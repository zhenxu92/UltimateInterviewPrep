import java.util.*;
public class LastString {
    public static void main(String args[]) {
        String s = "bananna";
        System.out.println(compute(s));
    }
    
    public static String compute(String s) {
        List<Integer>[] map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            int idx = c - 'a';
            List<Integer> list =  map[idx];
            list.add(idx);
        }
        StringBuider sb = new StringBuilder();
        char end = ' ';
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) end = 'a' + i;
        }
    }
}