import java.util.*;
public class FourInteger {
    public static void main(String args[]) {
        int[] arr = new int[]{1, 2, 3, 4};
        // 3,1,4,2
        System.out.println(Arrays.toString(fourInteger(arr)));
    }
    
    
    // TODO
    public static int[] fourInteger(int[] arr) {
        int[] res = new int[arr.length];
        res[0] = arr[2];
        res[1] = arr[0];
        res[2] = arr[3];
        res[3] = arr[1];
        List<List<Integer>> lists = permutation(arr);
        int max = Integer.MIN_VALUE;
        List<Integer> result = null;
        for (List<Integer> list : lists) {
            int temp = calculate(list);
            if (temp > max) {
                result = list;
                max = temp;
            }
        }
        int[] res2 = new int[arr.length];
        for (int i = 0; i < result.size(); i++) {
            res2[i] = result.get(i);
        }
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(res2));
        return res;
    }
    
    public static List<List<Integer>> permutation(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[arr.length];
        backTracking(res, arr, new ArrayList<Integer>(), visited, 0);
        return res;
    }
    
    public static void backTracking(List<List<Integer>> res, int[] arr, List<Integer> tempList, boolean[] visited, int start) {
        if (start == arr.length) {
            res.add(new ArrayList<Integer>(tempList));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            tempList.add(arr[i]);
            visited[i] = true;
            backTracking(res, arr, tempList, visited, start + 1);
            visited[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
    
    public static int calculate(List<Integer> list) {
        int sum = 0;
        for (int i = 1; i < list.size(); i++) {
            sum += Math.abs(list.get(i) - list.get(i - 1));
        }
        return sum;
    }
}