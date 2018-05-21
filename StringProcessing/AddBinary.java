public class AddBinary {
    public static void main(String args[]) {
        double x = 12.8;
        double y = 2.9;
        System.out.println((int)x * (long)y);
        String a = "100";
        String b = "110010";
        System.out.println(addBinary(a, b));
    }
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >=0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i) - '0';
            if (j >= 0) sum += b.charAt(j) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }
        if (carry != 0) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}