import java.util.*;
public class MaxConsecOnes {
    public static Queue<int[]> q = new LinkedList<int[]>();
    public static void main(String args[]) {
        int[] arr = new int[]{0, 0, 1, 0, 1, 1, 0};
        findMaxConsecutiveOnes(arr);
    }
    
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        if (nums == null || nums.length == 0) return max;
        int start = -1;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && start != -1) {
                end = i;
                q.add(new int[]{start, end});
                start = -1;
                end = 0;
                continue;
            }
            
            if (nums[i] != 0 && start == -1) {
                start = i;
            }
        }
        if (!q.isEmpty()) {
            int[] cur = q.remove();
        }
        
        if (q.isEmpty()) return cur[1] - cur[0] + 1;
        
        while (!q.isEmpty()) {
            int[] temp = q.remove();
            if (cur[1] + 1 == temp[0]) {
                max = Math.max(max, temp[1] - cur[0]);
            }
            cur = temp;
        }
        return max;
    }
}