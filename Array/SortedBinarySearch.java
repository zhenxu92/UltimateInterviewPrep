// binary search in a sorted array
import java.util.*;
public class SortedBinarySearch {
    public static void main(String args[]) {
        int[] arr = new int[] {2, 1, 3, 4, 5, 7 ,8 ,9, 10};
        Arrays.sort(arr);
        int target = 6;
        String result = new String();
        if(find(target, arr, 0, arr.length)) {
            result = " is found";
        } else {
            result = " is not found";
        }
        
        System.out.println("Target " + target + result + " in the array.");
    }
    
    public static boolean find(int target, int[] arr, int lo, int hi) {
        int mid = (hi + lo) / 2;
        if (hi <= lo) {
            return false;
        }

        if (arr[mid] == target) {
            return true;
        } 
        
        if (arr[mid] < target) {
            return find(target, arr, mid + 1, hi);
        } else {
            return find(target, arr, lo, mid - 1);
        }
        // alternatively you can use hi == lo
        // then use find(target, arr, lo, mid)
        // because, if use mid - 1 could cause hi < lo, which
        // does not meet hi == lo, causing the program run forever
    }
}