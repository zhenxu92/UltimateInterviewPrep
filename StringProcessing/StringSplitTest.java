// String Split Test
// @author: Zhen Xu
// This is a test program which examine the right way to use
// split method for string project
public class StringSplitTest {
    public static void main (String args[]) {
        String str = "a d, m, i. n";
        String[] arr = str.split("[ ,.]+"); //This line test this kind of regex
        for (String token : arr) {
            System.out.println(token);
        }
        String[] arr2 = str.split("\\s+|,\\s*|\\.\\s*");
        for (String token : arr2) {
            System.out.println(token);
        }  
    }
}