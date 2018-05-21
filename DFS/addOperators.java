import java.util.*;
public class addOperators {
    // the results
    private static List<String> res = new ArrayList<>();
    
    public static void main(String args[]) {
        // target
        int n = 100;
        calcOperations(n);
        System.out.println(res.toString());
        // testing use the calculator I built
        CalculatorII calc = new CalculatorII();
        for (String s : res) {
            System.out.println(calc.calculate(s));
        }
    }  
    
    /*
     * This method takes in an integer n, find 
     * the combinations of operations(subtract
     * and sum) within 1-9 to equal to n.
     * 
     * @param n, the target number
     * @return res, a list of combinations
     */ 
    public static List<String> calcOperations(int n) {
        find(2, n, "1", "1"); 
        return res;   
    }
    /*
     * This method is a helper method for 
     * calcOperations to find combinations
     *
     * @param start, start of the search.
     * @param sum, the target summation.
     * @param cur, the resulting string.
     * @param last, the last calculated number
     */
    private static void find(int start, int sum, String cur, String last) {
        int val = Integer.parseInt(last);
        if (start == 10) {
            if (sum - val == 0) res.add(cur);
            return;
        }

        find(start + 1, sum - val, cur + "+" + start, "" + start);
        find(start + 1, sum - val, cur + "-" + start, "-" + start);
        find(start + 1, sum, cur + start, last + start);
    }
}