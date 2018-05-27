public class StringCompression {
    public static void main(String args[]) {
        char[] chars = new char[]{'a', 'a', 'a','b','b'};
        int ans = compress(chars);
        for (int i = 0; i < ans; i++) {
            System.out.print(chars[i]);
        }
    }
    
    private static int compress(char[] chars) {
        int head = 0;
        int count = 0;
        for (int tail = 0; tail < chars.length; tail++) {
            if (chars[tail] != chars[head]) {
                // doSomething
                head++;
                if (count == 1) continue;
                char[] seq = Integer.toString(count).toCharArray();
                for (char c : seq) {
                    chars[head] = c;
                    head++;
                }
                count = 1;
            } else {
                count++;
            }
        }
        if (count != 0) {
            if (count == 1) return head + 1;
            head++;
            char[] seq = Integer.toString(count).toCharArray();
            for (char c : seq) {
                chars[head] = c;
                head++;
            }
        }
        return head;
    }
}