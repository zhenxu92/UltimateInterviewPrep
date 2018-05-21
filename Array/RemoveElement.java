public class RemoveElement {
    public static void main(String args[]) {
        int[] arr = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        remove(arr, 2);
    }
    
    public static int remove(int[] nums, int val) {
        int length = nums.length;
        int head = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                int temp = nums[i];
                nums[i] = nums[head];
                nums[head] = temp;
                head++;
            } else {
                length--;
            }
        }
        return length;    
    }
}