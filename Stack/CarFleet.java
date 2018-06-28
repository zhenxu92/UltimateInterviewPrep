import java.util.*;
public class CarFleet {
    public static void main(String args[]) {
        int target = 12;
        int[] pos = new int[]{10, 8, 0, 5, 3};
        int[] speed = new int[]{2,4,1,1,3};
        System.out.println(carFleet(target, pos, speed));
    }
    
    public static int carFleet(int target, int[] pos, int[] speed) {
        TreeMap<Integer, Integer> fleet = new TreeMap<>();
        for (int i = 0; i < pos.length; i++) {
            fleet.put(target - pos[i], speed[i]);
        }
        
        double prev = -1.0;
        int res = 0;
        for (Integer dist : fleet.keySet()) {
            int v = dist;
            int w = fleet.get(dist);
            double t = 1.0 * v / w;
            if (t > prev) {
                prev = t;
                res++;
            }
        }
        return res;
    }
}