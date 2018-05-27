import java.util.*;
public class KeysAndRooms {
    public static void main(String args[]) {
        List<List<Integer>> rooms = new ArrayList<>();
        Integer[][] input = new Integer[][]{{2},{0},{1}};

        for (Integer[] arr : input) {
            List<Integer> cur = new ArrayList<Integer>();
            cur.addAll(Arrays.asList(arr));
            rooms.add(cur);
        }
        System.out.println(canVisitAllRooms(rooms));
    }
    
    private static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        List<Integer> zero = rooms.get(0);
        for (Integer key : zero) stack.push(key);
        while (!stack.isEmpty()) {
            int tp = stack.pop();
            if (visited[tp] == true) {
                continue;
            } else {
                visited[tp] = true;
                List<Integer> cur = rooms.get(tp);
                for (int n : cur) {
                    stack.push(n);
                }
            }
        }
        for (boolean b : visited) {
            if (b == false) return false;
        }
        return true;
    }
}   