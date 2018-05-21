public class EvenOddPattern {
    public static void main(String args[]) {
        printPattern(2);
    }
    
    // num >= 0
    public static void printPattern(int num) {
        if (num % 2 == 0) {
            System.out.print(0);
            for(int i = 2; i <= num; i = i + 2) {
                System.out.print(" " + i);
            }
        } else {
            System.out.print(1);
            for (int i = 3; i <= num; i = i + 2) {
                System.out.print(" " + i);
            }
        }
    }
}