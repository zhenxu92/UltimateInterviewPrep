import java.util.*;
public class TwoSumII {
    public static void main (String args[]) {
        int[] numbers = {0, 0, 3, 4};
        System.out.println(Arrays.toString(twoSum(numbers, 0)));
    }
    
    public static int[] twoSum(int[] numbers, int target) {
        int p1 = 0;
        int p2 = numbers.length - 1;
        int sum = numbers[p1] + numbers[p2];
        while (sum != target) {
            if (sum > target) {
                p2--;
            }
            if (sum < target) {
                p1++;
            }
        }
        int[] indices = new int[2];
        indices[0] = p2 + 1;
        indices[1] = p1 + 1;
        return indices;
    }
}