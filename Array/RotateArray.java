// #189 Rotate Array
import java.util.*;
public class RotateArray {
    public static void main(String args[]) {
        int[] arr = new int[]{1, 2, 3, 4};
        rotate(arr, 2);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int temp = -1;
        //int count = 0;
        int start = 0;
        // int tp = nums[start];
        while (start < nums.length) {
            int next = (start + k) % nums.length;
            
            start++;
        }
    }
}