// ConverTo7
// @author: Zhen Xu
// 
// This program takes in a decimal integer and then convert
// it into 7 base integer. Mathematically, just divide this 
// number by 7 till it cannot be dividd no more and record 
// its residual will complete the convert.
// 100 / 7 = 14 ... 2
// 14 / 7 = 2 ... 0
// 2 / 7 = 0 ... 2
// 202 is the answer
public class ConvertTo7 {
    public static void main (String args[]) {
        int input = 100;
        String output = convertTo7(input);
        System.out.println(output);
    }
    
    public static String convertTo7(int num) {
        int n = num;
        String str = "";
        System.out.println(n % 7);
        while (n > 7) {
            int temp = n % 7;
            System.out.println(temp);
            str += temp;
            n = n / 7;
        }
        str += n;
        return str;
    }
}