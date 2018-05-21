/*
This program tests if nextInt() method can read integers regardless of line breaking,
i.e. \n
*/
import java.util.*;
import java.io.*;

public class testNextInt {
    public static void main(String args[]) throws FileNotFoundException {
        Map<Integer, Integer> edges = new TreeMap<Integer, Integer>();
        Scanner input = new Scanner(new File("testNextInt"));
        while(input.hasNextInt()) {
            int start = input.nextInt();
            int end = input.nextInt();
            edges.put(start, end);
        }
        for(Integer v : edges.keySet()) {
            System.out.println(v + " " + edges.get(v));
        }
    }   
}