public class BinarySearch {
    public static void main(String args[]) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(findFirstSmaller(arr, 5));
    }
    
    private static int findFirstSmaller(int[] arr, int target) {
        int hi = arr.length - 1;
        int lo = 0;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < target) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}