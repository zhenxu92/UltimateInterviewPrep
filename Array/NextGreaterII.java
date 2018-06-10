import java.util.*;
public class NextGreaterII {
    public static void main(String args[]) {
        int[] nums = new int[]{6,7,9,4,1,5,2,3,3,3};
        int[] res = nextGreaterElements(nums);
        for (int n : res) {
            System.out.print(n + " ");
        }
    }

    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length * 2];
        Arrays.fill(res, -1);
        // double the length
        int[] tp = new int[nums.length * 2];
        for (int i = 0 ; i < tp.length; i++) {
            tp[i] = nums[i % nums.length];
        }
        int j = 1;
        stack.push(0);
        while (!stack.isEmpty() && j < tp.length) {
            int cur = tp[stack.peek()];
            if (tp[j] <= cur) {
                stack.push(j);
                j++;
            } else {
                res[stack.pop()] = tp[j];
                if (stack.isEmpty()) {
                    stack.push(j);
                    j++;
                }
            }
        }
        
//         Stack<Integer> tp = new Stack<>();
//         while (!stack.isEmpty()) {
//             tp.push(stack.pop());
//         }
//         //System.out.println(tp.isEmpty());
//         if (tp.isEmpty()) return res;
//         int max = tp.pop();
//         //System.out.println(nums[max]);
//         res[max] = -1;
//         while (!tp.isEmpty()) {
//             int index = tp.pop();
//             if (nums[max] <= nums[index]) {
//                 res[index] = -1;
//             } else {
//                 res[index] = nums[max];
//             }
//         }
        
        return Arrays.copyOfRange(res, 0, nums.length);
    }
}