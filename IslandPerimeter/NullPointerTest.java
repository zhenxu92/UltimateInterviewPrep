public class NullPointerTest {
    public static void main (String args[]) {
        int[][] twod = new int[2][2];
        for (int i = 0; i < twod.length; i++) {
            for (int j = 0; j < twod[i].length; j++) {
                twod[i][j] = i + j;
            }
        }
//         if (twod[0][0] == null) {
//             System.out.println("There is a null pointer for out of bound element");
//         } 
        System.out.println(twod[-1][-1]);  
    }
}
