import java.util.*;
class AdvantageShuffle {
    public static void main(String args[]) {
//     [8,2,4,4,5,6,6,0,4,7]
// [0,8,7,4,4,2,8,5,2,0]
        int[] a = new int[]{8,2,4,4,5,6,6,0,4,7};
        int[] b = new int[]{0,8,7,4,4,2,8,5,2,0};
        System.out.println(Arrays.toString(advantageCount(a, b)));
    }
    
    public static int[] advantageCount(int[] A, int[] B) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        for (int i = 0; i < B.length; i++) {
            pq.add(new int[]{B[i], i});
        }
        Arrays.sort(A);
        int[] res = new int[A.length];
        Arrays.fill(res, -1);
        int start = 0;
        while (!pq.isEmpty()) {
            int[] next = pq.remove();
            int temp = next[0];
            while (start < A.length) {
                int cur = A[start];
                if (cur > temp) {
                    int pos = next[1];
                    res[pos] = cur;
                    A[start] = -1;
                    break;
                } 
                start++;
            }
        }
        
        // process the remaining zeros
        int i = 0; 
        int j = 0;
        while (i < A.length && j < A.length) {
            if (A[i] == -1) {
                i++;
                continue;
            }
            if (res[j] != -1) {
                j++;
                continue;
            }
            res[j] = A[i];
            j++;
            i++;
        }
        
        return res;
    }
}