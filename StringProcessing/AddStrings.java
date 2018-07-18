public class AddStrings {
    public static void main(String args[]) {
        String num1 = "999";
        String num2 = "";
        System.out.println(addStrings(num1, num2));
    }

    public static String addStrings(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int[] sums = new int[Math.max(l1, l2) + 1];
        int i = l1 - 1;
        int j = l2 - 1;
        int pos = sums.length - 1;
        while (i >= 0 || j >= 0) {
            int sum = 0;
            if (i >= 0) {
                sum += (int)(num1.charAt(i) - '0');
                i--;    
            }
            if (j >= 0) {
                sum += (int)(num2.charAt(j) - '0');
                j--;
            }            
            sums[pos] += sum; 
            pos--; 
        }   
        
        int carry = 0;
        for (int start = sums.length - 1; start >= 0; start--) {
            int digit = (sums[start] + carry) % 10;
            carry = (sums[start] + carry) / 10;
            sums[start] = digit;
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < sums.length; k++) {
            sb.append(sums[k]);
        }
        while (sb.length() >= 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return (sb.length() == 0) ? "0" : sb.toString();
    }
}