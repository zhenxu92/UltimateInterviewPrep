import java.util.stream.IntStream;
public class TestSystemExit {
    public static void main(String args[]) {
        IntStream.range(0, 10).forEach(e -> doSomething(e));
    }
    
    public static void doSomething(int i) {
        System.out.println("This is " + i + "th execution");
        System.exit(0);
    }
}