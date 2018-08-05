import java.util.*;
public class CloseTwoSum {

    public static void main(String args[]) {
        double capacity = 3.0;
        double[] weights = new double[]{1,3,4,5,1.9};
        int numOfContainers = 3;
        Container c = findOptimalWeight(capacity, weights, numOfContainers);
        System.out.println(c.first + " " + c.second);
    }
    
    public static Container findOptimalWeight(double capacity, double[] weights, int numOfContainers) {
        if (weights == null || weights.length == 0) return null;
        Arrays.sort(weights);
        int minPos = 0;
        int maxPos = weights.length - 1;
        double min = 0.0;
        int i = minPos;
        int j = maxPos;
        while (i < j) {
            double sum = weights[i] + weights[j];
            if (sum > min || sum <= capacity) {
                minPos = i;
                maxPos = j;
                min = sum;
            }
            
            if (sum > capacity) {
                j--;
            } else {
                i++;
            }
        }
            
            Container c = new Container();
            c.first = weights[minPos];
            c.second = weights[maxPos];
            return c;
         
    }
    
    
    static class Container {
        public double first;
        public double second;
    }
}