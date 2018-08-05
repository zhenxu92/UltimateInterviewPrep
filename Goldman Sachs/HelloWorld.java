import java.util.*;
public class HelloWorld{
     public static void main(String []args){
        String[] source1 = new String[]{"/*Test program */", "int main()", "{ ","// break;", "   multiline  ", "   comment for ", "/*testing*/", "a = b + c;","/*}", "}"};
        String[] source2 = new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", " /*This is a test", "   multiline  ", "   comment for ", "/*testing", "a = b + c;", "}"};
        String[] source3 = new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "This is a test", "   multiline  ", "   comment for ", "testing*/", "a = b + c;", "}"};
        String[] source4 = new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/*/*This is a test", "   multiline  ", "   comment for ", "testing", "a = b + c;", "}"};
        
        
        for (String s : source1) {
            System.out.println(s);
        }
        System.out.println(removeComments(source1));
         System.out.println(removeComments(source2));
         System.out.println(removeComments(source3));
         System.out.println(removeComments(source4));
     }
     public static String removeComments(String[] source) {
        boolean inBlock = false;
        String res = "";
        String buffer = "";
        List<String> ans = new ArrayList();
        for (String line: source) {
            int i = 0;
            char[] chars = line.toCharArray();
            while (i < line.length()) {
                if (i + 1 < line.length() && chars[i] == '/' && chars[i + 1] == '/') {
                    break;
                } else if (buffer.length() != 0) {
                    if (i + 1 < line.length() && chars[i] == '*' && chars[i + 1] == '/') {
                        buffer = "";
                        i += 2;    
                    } else {
                        buffer += chars[i];
                        i++;
                    }  
                } else {
                    if (i + 1 < line.length() && chars[i] == '/' && chars[i + 1] == '*') {
                        buffer += chars[i];
                        buffer += chars[i + 1];
                        i += 2;
                    } else {
                        res += chars[i];
                        i++; 
                    }
                }       
            }
            if (buffer.length() != 0) {
                buffer += System.lineSeparator();
            }else{
                res += System.lineSeparator();
            }
        }
        return res + buffer;
    }
}