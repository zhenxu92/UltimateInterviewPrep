import java.util.*;
public class CloseTwoSum {

    public static void main(String args[]) {
        double capacity = 3.0;
        double[] weights = new double[]{};
        int numOfContainers = 3;
        Container c = findOptimalWeight(capacity, weights, numOfContainers);
        System.out.println(c.first + " " + c.second);
    }
    
    public static Container findOptimalWeight(double capacity, double[] weights, int numOfContainers) {
            Arrays.sort(weights);
            int min = 0;
            int max = 1;
            double m = 0.0;
            
            int i = 0;
            int j = weights.length - 1;
            while (i < j) {
                double sum = weights[i] + weights[j];
                
                if (sum > m && sum <= capacity) {
                    m = sum;
                    min = i;
                    max = j;
                }
                
                if (sum >= capacity) j--;
                else i++;
            }
            
            Container c = new Container();
            c.first = weights[min];
            c.second = weights[max];
            return c;
         
    }
    
    
    static class Container {
        public double first;
        public double second;
    }
}