import java.util.*;
public class MoveZeroes {
    public static void main(String args[]) {
        int[] arr = {0,1,0,3,12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void moveZeroes(int[] nums) {
        int lo = 0;
        for (int hi = 0; hi < nums.length; hi++) {
            if (nums[hi] == 0) continue;
            int temp = nums[hi];
            nums[hi] = nums[lo];
            nums[lo] = temp;
            lo++;
        }
    }
}