// this class will render an 2D array input as
// "[[1,2,3,4],[4,5,6,7]]" into a actual Integer
// 2D array.

// There are many chances where the format of input
// string would have more space, here so far we just 
// assume that the format is strictly following the 
// example.

// TODO: implement a way that the input can have 
// spaces and can be 1D array. The entries of the 
// array can be all types of objects or primitive
// type. 

import java.util.*;

public class IntArrayConverter {

    private List<List<Integer>> list;
    public IntArrayConverter(String input) {
        list = new ArrayList<>();
        String[] arrs = input.split("[\\[,\\]]");
        for (String arr : arrs) {
            List<Integer> temp = new ArrayList<Integer>();
            String[] nums = arr.split(",");
            for (String num : nums) {
                temp.add(Integer.parseInt(num));
            }
            this.list.add(temp);
        }
    }

    public int[][] convert() {
        int m = list.size();
        int n = list.get(0).size();
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = list.get(i).get(j);
            }
        }
        return res;
    }

    public static void main(String args[]) {
        
    }
}