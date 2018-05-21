public class PrimeNumberSelection {
   public static void main(String args[]) {
      for(int i = 15; i < 20; i++) {
         for(int j = 2; j < i; j++) {
            if(i % j ==0) {
               System.out.println(i + "=" + j + "*" + i/j);
               break;
            } else {
                System.out.println(i + "is a prime number");
            }
         }
      }
   }
}