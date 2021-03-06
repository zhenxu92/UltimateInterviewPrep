import java.util.*;
public class LemonadeChange {
    public static void main(String args[]) {
        int[] bills = new int[]{5,5,5,5,20,20,5,5,5,5};
        
        System.out.println(lemonadeChange(bills));
    }
    
    public static boolean lemonadeChange(int[] bills) {
        // ds to store bills
        // ds to store debts
        int[] changes = new int[2];
        List<Integer> debts = new ArrayList<Integer>();
        for (int i = 0; i < bills.length; i++) {
            int bill = bills[i];
            if (bill == 5) {
                changes[0]++;
            } else if (bill == 10) {
                if (changes[0] > 0) {
                    changes[1]++;
                    changes[0]--;
                } else {
                    return false;
                }
            } else {
                if (changes[1] > 0 && changes[0] > 0) {
                    changes[1]--;
                    changes[0]--;
                } else if (changes[1] < 1 && changes[0] >= 3) {
                    changes[0] -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}