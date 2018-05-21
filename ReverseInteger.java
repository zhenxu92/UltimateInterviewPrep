// This progarm is a test for reversing an integer, using 
// recursion. List is used here to store the digits, stack
// can also be used here, might be easier.

import java.util.*;

public class ReverseInteger {
    public static void main(String args[]) {
        // find each digits, then store them in a list
        int integer = 233445;
        int value = 10;
        Stack<Integer> arr = new Stack<Integer>();
        reverse(value, integer, arr);
        for(int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i));
        }
        System.out.println();
        // Test stack, Q: why does stack has a get method?
        // System.out.println(arr.pop());
        
        // add the number together into result
 
        
            
    }
    
    public static int add(int value, Stack<Integer> s, int result) {
        if(s.isEmpty()) {
            return result;
        } else {
            return result + s.pop() * value + add(value * 10, s, result);
        }
    }
    
    public static void reverse(int value, int integer, Stack<Integer> list) {
        if(integer % value == integer) {
            list.add(integer % value / (value / 10));
        } else {
            list.add(integer % value / (value / 10));
            reverse(value * 10, (integer - (integer % value)), list);
        }
    }
    
}