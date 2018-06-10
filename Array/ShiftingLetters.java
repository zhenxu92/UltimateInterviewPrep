public class ShiftingLetters {
    public static void main(String args[]) {
        String s = "mkgfzkkuxownxvfvxasy";
        int[] shifts = new int[]{505870226,437526072,266740649,224336793,532917782,311122363,567754492,595798950,81520022,684110326,137742843,275267355,856903962,148291585,919054234,467541837,622939912,116899933,983296461,536563513};
        System.out.println(shiftingLetters(s, shifts));
         
    }
    
    public static String shiftingLetters(String S, int[] shifts) {
        char[] carr = S.toCharArray();
//         int[] seq = new int[carr.length];
//         for (int i = 0; i < carr.length; i++) {
//             seq[i] = carr[i];
//         }
        long sum = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            sum += shifts[i];
            int times = (int)(sum % 26);
            shifts[i] = times;
        }
        for (int i = 0; i < carr.length; i++) {
            char value = (char)(((carr[i] - 'a' + shifts[i])) % 26 + 'a');
            carr[i] = value;
        }
        return new String(carr);
    }
}