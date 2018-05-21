// ReadNumbers
// @author Zhen Xu
// Count 1211 as 111221 (one 1, one 2, two 1)
// Given 1211 as a string
public class ReadNumber {
    public static void main (String args[]) {
        String str = "1111";
        String ans = Solution(str);
        System.out.println(ans);    
    }
    
    public static String Solution(String str) {
        int count = 1;
        String ans = "";
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;    
            } else {
                ans = ans + count + str.charAt(i);
                count = 1;    
            }
        }
        if (count != 1) {
            ans = ans + count + str.charAt(str.length() - 1);
        } else {
            ans = ans + count + str.charAt(str.length() - 1);
        }
        return ans;
    }
    

}