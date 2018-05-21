public class test {
    public static void main(String args[]) {
        int x = 1;
        int y = 1;
        int z = 1;

        myFun(x, y, z--);
        System.out.println(z);
        String ans = "";
        int quotient = 256;          
        while (quotient > 0) {
            int rem = quotient % 14;
            if (rem => 0 && rem <= 9) {
                ans = rem + ans;
            } else if (rem == 10 || ...) {
                ans = A + ans;
            }
            quotient = quotient / 14;
        }
    }
    
    public static void myFun(int x, int y, int z) throws IllegalArgumentException {
        int dd = x;
        if (dd > 0) {
            System.out.println("Your input is not valid, the program will end.");
            throw new IllegalArgumentException();
        }
    }

}