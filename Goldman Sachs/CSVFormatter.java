import java.util.*;
public class CSVFormatter {
    public static void main(String args[]) {
        String[][] arr = new String[][]{
            {"id,", "name,", "DOB"},
            {"1,", "Zhen Xu,", "1992-02-13"},
            {"2,", "Zhang San,", "1992-04-13"},
            {"3,", "Ragnorak Smithson,", "1986-05-07"}
        };
        List<String> input = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < arr[0].length; j++) {
                sb.append(arr[i][j]);
            }
            input.add(sb.toString());
        }
        
        System.out.println(csvFormatter(input));
    }
    
    public static String csvFormatter(List<String> input) {
        if (input == null || input.size() == 0) return "Empty input!"; 
        int m = input.size();
        int n = input.get(0).split(",").length;
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        int[] max = new int[n];
        for (int i = 0; i < m; i++) {
            String[] strs = input.get(i).split(",");
            for (int j = 0; j < strs.length; j++) {
                String str = strs[j];
                max[j] = Math.max(max[j], str.length());  
                List<String> tempList = list.get(j);
                tempList.add(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                String cur = list.get(j).get(i);
                int numOfSpaces = max[j] - cur.length();
                for (int k = 0; k < numOfSpaces; k++) {
                    sb.append(" ");
                }
                sb.append(cur);
                sb.append(" ");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}