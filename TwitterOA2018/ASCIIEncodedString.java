import java.util.*;
public class ASCIIEncodedString {
    public static void main(String args[]) {
        String encode = "701011792823411101701997927";
        System.out.println(decode(encode));
    }
    
    private static String decode(String encode) {
        StringBuilder sb = new StringBuilder(encode);
        encode = sb.reverse().toString();
        sb.delete(0, sb.length());  
        int i = 0;
        while (i < encode.length()) {
            char c = encode.charAt(i);
            if (c == '1') {
                int ascii = Integer.parseInt(encode.substring(i, i + 3));
                sb.append((char) ascii);
                i += 3;
            } else {
                int ascii = Integer.parseInt(encode.substring(i, i + 2));
                i += 2;
                sb.append((char) ascii);
            }
        } 
        return sb.toString();
    }
}