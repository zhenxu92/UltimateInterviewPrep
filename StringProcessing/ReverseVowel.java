public class ReverseVowel {
    public static void main(String args[]) {
        String s = "HELLO";
        System.out.println(reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        if (s == null || s.length() < 1) return "";
        String lc = s.toLowerCase();
        char[] ca = lc.toCharArray();
        char[] res = s.toCharArray();
        int lo = 0;
        int hi = ca.length - 1;
        boolean foundLeft = false;
        boolean foundRight = false;
        while (lo < hi) {
            if (ca[lo] == 'a' || ca[lo] == 'e' || ca[lo] == 'i' || ca[lo] == 'o' || ca[lo] == 'u') {
                foundLeft = true; 
            } else {
                lo++;
            }
            if (ca[hi] == 'a' || ca[hi] == 'e' || ca[hi] == 'i' || ca[hi] == 'o' || ca[hi] == 'u') {
                foundRight = true; 
            } else {
                hi--;
            }
            // swap
            if (foundLeft && foundRight) {
                char temp = res[lo];
                res[lo] = res[hi];
                res[hi] = temp;
                foundLeft = false;
                foundRight = false;
                lo++;
                hi--;
            }
        }
        return new String(res);
    }

}