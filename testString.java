// This program test the method of String object and StringBuilder Object
import java.util.*;
import java.io.*;
public class testString {
    public static void main(String args[]) {
        String s = "ab12";
        byte[] arr = s.getBytes();
//         for(int i = 0; i < arr.length; i++) {
//             System.out.print(arr[i]+" ");
//         }
        Scanner sc = new Scanner(System.in);
        String c = sc.nextLine();
        System.out.println(c);
        String[] arr = new String[2];
        int count = 0;
        String str = "";
        for (int i = 0; i < c.length(); i++) {
            char ch = c.charAt(i);
            if (ch != ' ') {
                str += ch;
            } else {
                count++;
                arr[0] = str;
                str = "";
            }
        }
        
        if (count != 1 || arr[1] == null) {
            
        }
    }
}