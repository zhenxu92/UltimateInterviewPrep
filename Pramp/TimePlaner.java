public class TimePlaner {
    public static void main(String args[]) {
        int[][] slotsA = new int[][] {
            {10, 15},
            {60, 120},
            {140, 210}
        };
        int[][] slotsB = new int[][] {
            {0, 15},
            {60, 70}
        };
        int dur = 8;
        int[] res = timePlaner(slotsA, slotsB, 8);
        System.out.println("Your plan will start at " + res[0] + " and ends at " + res[1]);
    }
    
    private static int[] timePlaner(int[][] slotsA, int[][] slotsB, int dur) {
        if (slotsA == null || slotsA.length == 0) return new int[]{0, 0};
        if (slotsB == null || slotsB.length == 0) return new int[]{0, 0};
        int i = 0;
        int j = 0;
        while (i < slotsA.length && j < slotsA.length) {
            // judge
            int[] ai = slotsA[i];
            int[] bi = slotsB[j];
            int start = Math.max(ai[0], bi[0]);
            int end = Math.min(ai[1], bi[1]);
            if (end - start >= dur) return new int[]{start, start + dur};
            
            if (ai[1] > bi[1]) {
                j++;
            } else {
                i++;
            }
        }
        return new int[]{0, 0};
    }
}