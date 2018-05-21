import java.util.*;
public class FizzBuzz {
    public static void main(String args[]) {
        int n = 30;
        List<String> fzbz = fizzBuzz(n);
        for(String s : fzbz) {
            System.out.print(s + " ");
        }
    }
    
    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                String str = Integer.toString(i);
                list.add(str);
            }
        }
        return list;
    }
}