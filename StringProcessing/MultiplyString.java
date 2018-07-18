public class MultiplyString {
    public static void main(String args[]) {
        String num1 = "123456789";
        String num2 = "987654321";
        System.out.println(multiply(num1, num2));
    }

    public static String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int[] products = new int[l1 + l2];
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                int digit1 = (int)(num1.charAt(i) - '0');
                int digit2 = (int)(num2.charAt(j) - '0');
                int product = digit1 * digit2;
                products[i + j + 1] += product;
            }
        }
        
        int carry = 0;
        for (int i = l1 + l2 - 1; i >= 0; i--) {
            int digit = (products[i] + carry) % 10;
            carry = (products[i] + carry) / 10;
            products[i] = digit;
        }
        
        StringBuilder sb = new StringBuilder();
        boolean notStarted = true;
        for (int i = 0; i < products.length; i++) {
            if (notStarted && products[i] == 0) continue;
            notStarted = false;
            sb.append(products[i]);
        }
        return (sb.length() == 0) ? "0" : sb.toString();
    }
}