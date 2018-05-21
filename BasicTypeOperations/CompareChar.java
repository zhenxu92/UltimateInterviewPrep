public class CompareChar {
    public static void main (String args[]) {
        char a = 'a';
        char b = 'b';
        char c = '1';
        char d = '2';
        
        // test if 'a' and 'b' are comparable
        if (a < b) {
            System.out.println("Characters can be compared by using its casted integer value!");
        }
        // test if '1' and '2' are comparable
        if (c < d) {
            System.out.println("Even integer numbers are in char form, it still compares.");
        }
        
        // test casting char to int
        int ei = (int) a;
        int bee = (int) b;
        System.out.println("casting 'a' to integer is " + ei + " and casting 'b' to integer" +
        " is " + bee);
        System.out.println();
        System.out.println("The result shows that you can cast char to int directy which" +
        " shows its ASCII value");
        
        System.out.println("Let's try more casting tests");
        System.out.println();
        System.out.println("What can you do with casting integer to char?" + "\n" +
        "Let's give it a try!");
        int integer = 97;
        char castInt = (char) integer;
        System.out.println("The result is" + castInt);
        System.out.println("Casting integer to char returns the ASCII value of the character. \n");
        System.out.println("Then what kind of transformation can we do among String, Integer, Character and Binary number? \n");
        
    }
}