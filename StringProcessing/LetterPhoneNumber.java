import java.util.*;
public class LetterPhoneNumber {
    public static void main(String args[]) {
        String number = "23";
        System.out.println(letterCombinations(number).toString());
    }
    public static List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<String>();
        if (digits == null || digits.length() < 1) return res;
        res.add("");
        String[] map = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);
            while (i == res.peek().length()) {
                String temp = res.poll();
                String str = map[(int)c -'0'];
                for (int j = 0; j < str.length(); j++) {
                    temp += str.charAt(j);
                    res.offer(temp);
                }
            }
        }
        return res;
    }
}