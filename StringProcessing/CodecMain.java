import java.util.*;
public class CodecMain {
    public static void main(String args[]) {
        List<String> list = new ArrayList<String>();
        list.add("1/");
        list.add("/");
        list.add("/");
        Codec c = new Codec();
        System.out.println(c.encode(list));
        System.out.println(c.decode(c.encode(list)).toString());
    }
}