import java.util.*;
public class SS {
    public static void main(String args[]) {
        int[] arr = new int[]{1,5,2,3,51,3,3,7};
        System.out.println(Arrays.toString(ss(arr)));
    }
    
    public static int[] ss(int[] arr) {
        int x = 0;
        int y = 0;
        int n = arr.length;
        for (x = 0; x < n; x++) {
            int min = x;
            for (y = x; y < n; y++) {
                if (arr[min] > arr[y]) {
                    min = y;
                }
            }
            int tp = arr[x];
            arr[x] = arr[min];
            arr[min] = tp;
        }
        return arr;
    }
}