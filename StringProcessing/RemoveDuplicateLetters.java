public class RemoveDuplicateLetters {
    public static void main(String args[]) {
        String s = "bcabc";
        removeDup(s);
    }   
    
    private static String removeDup(String s) {
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                int temp = i;
                char c = (char)temp; 
                System.out.print(c);    
                sb.append(c);
            }
        }
        return sb.toString();
    }
}