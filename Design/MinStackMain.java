public class MinStackMain {
    public static void main(String args[]) {
        MinStack ms = new MinStack();
        ms.push(5);
        ms.push(4);
        ms.push(1);
        ms.push(2);
        ms.push(-1);
        ms.push(7);
        System.out.println(ms.getMin());
        ms.pop();
        ms.pop();
        ms.pop();
        System.out.println(ms.getMin());
    }
}