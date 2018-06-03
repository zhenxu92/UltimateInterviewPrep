public class LongestMountain {
    public static void main(String args[]) {
        int[] A = new int[]{2, 1, 4, 7, 3, 2, 5, 6, 7, 3, 1};
        int[] B = new int[]{0, 2, 2};
        int[] C = new int[]{0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0};
        int[] D = new int[]{2,3,3,2,0,2};
        int[] E = new int[]{0,0,1,0,0,1,1,1,1,1};
        System.out.println(longestMountain(E));    
    }
    
    public static int longestMountain(int[] A) {
        int res = 0;
        // two pointer
        boolean foundMountain = false;
        boolean foundPeak = false;
        int lo = 0; 
        int hi = 1;
        while (hi < A.length) {
            if (A[hi] <= A[hi - 1] && foundMountain == false) {
                hi++;
                continue;
            }
            if (A[hi] > A[hi - 1] && foundMountain == false) {
                lo = hi - 1;
                hi++;
                foundMountain = true;
                continue;
            }
            if (foundMountain == true && A[hi] > A[hi - 1] && foundPeak == false) {
                hi++;
                continue;
            }
            if (foundMountain == true && A[hi] == A[hi - 1] && foundPeak == false) {
                lo = hi;
                foundMountain = false;
                hi++;
                continue;
            }
            if (foundMountain == true && A[hi] < A[hi - 1]) {
                foundPeak = true;
                hi++;
                continue;
            }
            if (foundMountain == true && foundPeak == true && A[hi] >= A[hi - 1]) {
                res = Math.max(hi - lo, res);
                lo = hi - 1;
                foundPeak = false;
                continue;
            }
            
        }
        if (foundMountain == true && foundPeak == true) {
            res = Math.max(res, hi - lo);
        }
        return res;
    }
}

