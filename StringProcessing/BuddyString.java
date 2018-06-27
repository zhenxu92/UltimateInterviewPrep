public class BuddyString {
    public static void main(String args[]) {
        String a = "ab";
        String b = "cb";
        System.out.println(buddyStrings(a, b));
    }
    public static boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            int[] dic = new int[26];
            for (int i = 0; i < A.length(); i++) {
                char c = A.charAt(i);
                dic[c - 'a']++;
            }
            for (int i = 0; i < dic.length; i++) {
                if (dic[i] > 1) return true;
            }
            return false;
        } else {
            int first = -1;
            int second = -1;
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (first == -1) {
                        first = i;
                    } else if (second == -1) {
                        second = i;
                    } else {
                        return false;
                    }
                }
            }
            if (first == -1 || second == -1) return false;
            return (A.charAt(first) == B.charAt(second) && A.charAt(second) == B.charAt(first)) ? true : false;
        }
    }
}