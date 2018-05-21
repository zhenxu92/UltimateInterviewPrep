import java.util.*;
public class MaxHistogram {
    public static void main(String args[]) {
        int[] heights = {2, 1, 2};
        System.out.println(largestRecArea(heights));
    }
    
    public static int largestRecArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack =  new Stack<Integer>();
        int len = heights.length;
        int max = 0;
        for (int i = 0; i <= len; i++) {
            int h;
            if (i == len) {
                h = 0;
            } else {
                h = heights[i];
            }
            if (stack.isEmpty() || h >= stack.peek()) {
                stack.push(i);
            } else {
                while(!stack.isEmpty() && h < heights[stack.peek()]) {
                    int tp = stack.pop();
                    if (stack.isEmpty() && i== len) {
                        max = Math.max(max, i * heights[tp]);
                    } else {
                        max = Math.max(max, (i - tp) * heights[tp]);
                    }
                }
            }
        }
        return max;
    }
}