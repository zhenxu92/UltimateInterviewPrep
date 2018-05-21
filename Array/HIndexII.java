public class HIndexII {
    public static void main(String args[]) {
        int[] arr = new int[]{0, 0};
        hIndex(arr);
    }   
    
    public static int hIndex(int[] arr) {
        int lo = 0;
        int len = arr.length;
        int hi = len - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            //if (arr[mid] == len - mid) return len - mid;
            if (arr[mid] <= len - mid) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return len - lo;
    }
}