
class BinaryGap {
    public static void main(String args[]) {
        int N = 0;
        System.out.println(binaryGap(N));
    }
    public static int binaryGap(int N) {
        int temp = N;
        int start = -1;
        int j = 0;
        int max = Integer.MIN_VALUE;
        while (temp > 0) {
            int val = temp & 1;
            if (val == 1) {
                if (start == -1) {
                    start = j;
                } else {
                    max = Math.max(j - start, max);
                    start = j;
                }
            }
            temp = temp >> 1;
            j++;
        }
        return (max == Integer.MIN_VALUE) ? 0 : max;
    }
}