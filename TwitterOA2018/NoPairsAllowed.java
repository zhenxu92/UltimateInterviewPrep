public class NoPairsAllowed {
    public static void main(String args[]) {
        String[] strs = new String[]{"ab", "aab", "abb", "abab", "abaaaba", "abaaabaaba"};
        for (String str : strs) {
            System.out.println(noPairsAllowed(str));
        }
    }
    
    public static int noPairsAllowed(String s) {
        int res = 0;
        int start = 0;
        int end = 0;
        char[] arr = s.toCharArray();
        while (end < arr.length) {
            char c = arr[start];
            int count = 0;
            while (end < arr.length && arr[end] == c) {
                count++;
                end++;
            }
            if (count >= 2) {
                res += count / 2;
            }
            count = 0;
            start = end;
        }
        return res;
    }
}