import java.util.Stack;
public class NextGreaterII {
    public static void main(String args[]) {
        int[] nums = new int[]{1, 2, 1};
        nextGreaterElements(nums);
    }

    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        int j = 1;
        stack.push(0);
        while (!stack.isEmpty() && j < nums.length) {
            int cur = nums[stack.peek()];
            if (nums[j] <= cur) {
                stack.push(j);
                j++;
            } else {
                res[stack.pop()] = nums[j];
            }
        }
        
        Stack<Integer> tp = new Stack<>();
        while (!stack.isEmpty()) {
            tp.push(stack.pop());
        }
        System.out.println(tp.isEmpty());
        if (tp.isEmpty()) return res;
        int max = tp.pop();
        System.out.println(nums[max]);
        res[max] = -1;
        while (!tp.isEmpty()) {
            int index = tp.pop();
            if (nums[max] <= nums[index]) {
                res[index] = -1;
            } else {
                res[index] = max;
                max = index;
            }
        }
        return res;
    }
}