public class ArithmeticSeq {
    // TODO
    // test how many arm seq inside
    // e.g.
    // 1 2 3 6 7 8
    // return 2
    public static void main(String args[]) {
        int[] seq = new int[]{1, 2, 3, 6, 7, 8};
        System.out.println(getLAS(seq));
    }
    
    public static int getLAS(int[] seq) {
        int res = 0;
        Integer cur = null;
        int start = 0;
        int count = 0;
        for (int i = 1; i < seq.length; i++) {
            if (cur == null) {
                cur = seq[i] - seq[i - 1];
            } else if (seq[i] - seq[i - 1] == cur) {
                count++;
            } else {
                
            }
        }
    }   
    
}