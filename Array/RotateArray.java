// #189 Rotate Array
import java.util.*;
public class RotateArray {
    public static void main(String args[]) {
        int[] arr = new int[]{1, 2, 3, 4,5,6,7};
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        // pos = (index + k) % n
        int count = 0;
        for (int i = 0; count < nums.length; i++) {
            int currentIndex = i;
            int nextVal = -1;
            int currentVal = nums[currentIndex];
            do {
                int nextIndex = (currentIndex + k) % n;
                nextVal = nums[nextIndex];
                nums[nextIndex] = currentVal;
                currentIndex = nextIndex;
                currentVal = nextVal;
                count++;
            } while (currentIndex != i);
        }
    }
}