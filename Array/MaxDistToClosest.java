public class MaxDistToClosest {
    public static void main(String args[]) {
        int[] seats = new int[]{1,0,0,0,1,0,1};
        System.out.println(maxDistToClosest(seats));
    }
    public static int maxDistToClosest(int[] seats) {
        int max = Integer.MIN_VALUE;
        int lo = 0;
        int hi = 0;
        while (hi < seats.length) {
            if (seats[hi] == 1) {
                if (seats[lo] == 0) {
                    max = Math.max(max, hi - lo);
                } else {
                    max = Math.max(max, (hi - lo) / 2);                    
                }
                lo = hi;
            }
            hi++;
        }
        if (seats[seats.length - 1] == 0) max = Math.max(max, seats.length - lo - 1);
        return max;
    }
}