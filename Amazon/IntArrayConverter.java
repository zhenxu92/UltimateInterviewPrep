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
import javax.json.*;
import java.util.regex.*;

public class IntArrayConverter {

    private List<List<Integer>> list;
    public IntArrayConverter(String input) {
         list = new ArrayList<>();
         String regex = "\\[?\\[((\\d,)+\\d)";
         String[] arrs = input.split(regex);
        // String[] arrs = input.split("[\\[,\\]]");
        Pattern r = Pattern.compile(regex);
        Matcher m = r.matcher(input);
        while (m.find()) {
            String temp = m.group(1);
            List<Integer> tempList = new ArrayList<>();
            String[] arr = temp.split(",");
            for (String num : arr) {
                tempList.add(Integer.parseInt(num));
            }
            list.add(tempList);
        }
//         JsonReader jsonReader = Json.createReader(new StringReader("[[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]"));
//         JsonArray array = jsonReader.readArray();
//         jsonReader.close();
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
        IntArrayConverter iac = new IntArrayConverter("[[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]");
        int[][] maze = iac.convert();
        for (int i = 0; i < maze.length; i++) {
            System.out.println(Arrays.toString(maze[i]));        
        }

    }
}