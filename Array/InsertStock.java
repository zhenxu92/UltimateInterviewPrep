import java.util.*;
public class InsertStock {

    public static void main(String args[]) {
        int[] stocks = new int[]{5,7,7,8,8,10};
        //insertStock(stocks, 5);
        System.out.println("The input stocks are: " + Arrays.toString(stocks));
        // All the following methods assume that array has no duplicates
//         System.out.println(findEqMin(stocks, 2));
//         System.out.println(findEqMax(stocks, 2));
//         System.out.println(findFirstSmaller(stocks, 9));
        int target = 6;
        // All the following methods assume that array could have duplicates
        System.out.println("The start of " + target + " ends at " + findFirstGreaterOrEqInDup(stocks, target));
        System.out.println("The end of " + target + " starts from " + findFirstSmallerOrEqInDup(stocks, target));
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
    
    // this method find the first element in an array that is 
    // greater than target
    public static int findFirstGreaterOrEqInDup(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid < 0 || mid >= nums.length) return -1;
            if (mid < nums.length - 1 && nums[mid] == target && nums[mid + 1] > target) return mid;
            if (mid > 0 && nums[mid] > target && nums[mid - 1] == target) return mid - 1;
            if (mid == nums.length - 1 && nums[mid] == target) return mid;
            if (nums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
    
    public static int findFirstSmallerOrEqInDup(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid < 0 || mid >= nums.length) return -1;
            if (mid < nums.length && nums[mid] < target && nums[mid + 1] == target) return mid + 1;
            if (mid > 0 && nums[mid] == target && nums[mid - 1] < target) return mid;
            if (mid == 0 && nums[mid] == target) return mid;
            if (nums[mid] >= target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}