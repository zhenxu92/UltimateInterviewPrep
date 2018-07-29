import java.util.*;
class RobotSim {
    public static void main(String args[]) {
        int[] commands = new int[]{4,-1,4,-2,4};
        int[][] obstacles = new int[][]{
            {2, 4}
        };
        
        System.out.println(robotSim(commands, obstacles));
    }

    public static int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obss = new HashSet<>();
        for (int[] obs : obstacles) {
            String temp = obs[0] + " " + obs[1];
            obss.add(temp);
        }
        int res = Integer.MIN_VALUE;
        int[] dir = new int[]{0, 1};
        int x = 0;
        int y = 0;
        for (int cmd : commands) {
            if (cmd < 0) {
                dir = turn(dir, cmd);
            } else {
                for (int i = 0; i < cmd; i++) {
                    int tx = x + dir[0];
                    int ty = y + dir[1];
                    String temp = tx + " " + ty;
                    if (!obss.contains(temp)) {
                        x = tx;
                        y = ty;
                        res = Math.max(res, x * x + y * y);                        
                    }
                }
            }
            System.out.println(dir[0] + ", " + dir[1]);
            System.out.println(x + ", " + y);
        }
        return res;
    }
    
    private static int[] turn(int[] cur, int cmd) {
        int[] temp = new int[2];
        temp[0] = cur[1];
        temp[1] = cur[0];
        if (cmd == -1) {
            temp[1] *= -1;
        }
        if (cmd == -2) 
            temp[0] *= -1;
        return temp;
    }}