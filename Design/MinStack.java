import java.util.*;
public class MinStack {
    Stack<Long> stack;
    long min;
    public MinStack() {
        stack = new Stack<Long>();
    }
    
    // @param x, the integer value put in the stack
    // push the value x into the stack
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = x;
        } else {
            if (x >= min) {
                stack.push(x - min);
            } else {
                stack.push(x - min);
                min = x;
            }
        }
    }
    
    // pop out the top element in the stack
    public void pop() {
        if (stack.isEmpty()) return;
        long temp = stack.pop();
        if (temp < 0) {
            // means that temp is coming from current min value
            // then, currMin - prevMin = temp -> prevMin = currMin - temp
            // so min = min - temp
            min = min - temp;
        }
    }
    
    // return an integer value on the top of the stack
    public int top() {
        long temp = stack.peek();
        // temp = real - min => real = temp + min
        if (temp >= 0) return (int)(temp + min);
        else {
            return (int)min;
        }
    }
    
    
    // return the minimum value in the list
    public int getMin() {
        return (int)min;
    }
}