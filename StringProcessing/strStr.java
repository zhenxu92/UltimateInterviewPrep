public class strStr {
    public static void main(String args[]) {
        String a = "hello";
        String b = "ll";
        System.out.println(strStr(a, b));
    }
    
    public static int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() > haystack.length()) return -1;
            boolean found = true;
            for (int j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    found = false;
                    break;
                }
            }
            if (found) return i;
        }
        return -1;
    }
}