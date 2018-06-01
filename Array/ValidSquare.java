public class ValidSquare {
    public static void main(String args[]) {
        
    }
    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // 3 ks
        // p1 p2 vs p3 p4
        double k12 = (p1[1] - p2[1]) * 1.0 / (p1[0] - p2[0]);
        double k34 = (p3[1] - p4[1]) * 1.0 / (p3[0] - p4[0]);
        double k13 = (p1[1] - p3[1]) * 1.0 / (p1[0] - p3[0]);
        double k24 = (p2[1] - p4[1]) * 1.0 / (p2[0] - p4[0]);
        double k14 = (p1[1] - p4[1]) * 1.0 / (p1[0] - p4[0]);
        double k23 = (p2[1] - p3[1]) * 1.0 / (p2[0] - p3[0]);
        
        if (k12 * k34 == -1 || k13 * k24 == -1 || k14 * k23 == -1) {
            if (k12 * k34 == -1) {
                check
            }    
        }
        return false;
    }
    
    
}