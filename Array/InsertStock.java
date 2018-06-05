import java.util.*;
public class InsertStock {

    public static void main(String args[]) {
        int[] stocks = new int[]{1, 3, 3, 4, 6, 7};
        //insertStock(stocks, 5);
        System.out.println(findEqMin(stocks, 2));
        System.out.println(findEqMax(stocks, 2));
        System.out.println(findFirstSmaller(stocks, 2));
 
    }
    
    private static void insertStock(Integer[] stocks, int stock) {
        List<Integer> myList = new ArrayList<Integer>(Arrays.asList(stocks));
    }
    
    // find the index of the first element smaller or equal
    // to that element
    private static int findEqMin(int[] arr, int target) {
        Arrays.sort(arr);
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            if (target >= arr[hi]) return hi;
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) return mid;
            if (mid > 0 && arr[mid] > target && arr[mid - 1] < target) {
                return mid - 1;
            }
            if (arr[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
    
    private static int findEqMax(int[] arr, int target) {
        Arrays.sort(arr);
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) return mid;
            if (mid < arr.length - 1 && arr[mid] < target && arr[mid + 1] >= target) {
                return mid + 1;
            }
            if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
    
    private static int findFirstSmaller(int[] arr, int target) {
        Arrays.sort(arr);
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // if target is the smallest element in the arr
            // it will return -1
            if (arr[mid] == target) return mid - 1;
            if (mid > 0 && arr[mid] > target && arr[mid - 1] < target) return mid - 1;
            if (arr[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}