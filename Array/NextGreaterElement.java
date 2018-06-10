// NextGreaterElement V1.0
// @author Zhen XU
// This is not correct yet
import java.util.*;
public class NextGreaterElement {
    public static void main (String args[]) {
        int[] findNums = {2, 4};
        int[] nums = {1,2,3,4};
        int[] ans = nextGreaterElement(findNums, nums);
        for (int n : ans) {
            System.out.print(n + " ");
        }
    }
    
    public static int[] nextGreaterElement (int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return new int[0];
        int[] res = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        // process map
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], -1);
        }
        Stack<Integer> stack = new Stack<>();
        int j = 1;
        stack.push(0);
        while (!stack.isEmpty() && j < nums2.length) {
            int cur = nums2[stack.peek()];
            if (cur < nums2[j]) {
                // found!
                map.put(nums2[stack.pop()], nums2[j]);
                if (stack.isEmpty()) {
                    stack.push(j);
                    j++;
                }
            } else {
                stack.push(j);
                j++;
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;        
    }
}