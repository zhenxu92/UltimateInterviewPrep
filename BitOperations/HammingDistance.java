public class HammingDistance {
    public static void main (String args[]) {
        int x = 2;
        int y = 8;
        int output = solution(x, y);
        System.out.println(output);
    }
    
    // 2 - 0010
    // 8 - 1000
    // ans =  2
    // 2 ^ 8 = 1010
    public static int solution(int x, int y) {
        int temp = x ^ y;
        int ans = 0;
        while (temp != 0) {
            temp = temp & (temp - 1);
            ans++;
        }
        return ans;
    }
}