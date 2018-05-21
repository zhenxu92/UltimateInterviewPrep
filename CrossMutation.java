import java.util.*;
public class CrossMutation {
    public static void main (String args[]) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        List<Integer> list3 = new ArrayList<Integer>();
        List<Integer> list4 = new ArrayList<Integer>();
        
        // add elements
        for (int i = 0; i < 10; i++) {
            list1.add(i);
        }
        for (int i = 0; i < 10; i++) {
            list2.add(9 - i);
        } 
        for (int i = 0; i < 10; i++) {
            list3.add(0);
            list4.add(0);
        }
        
               
        crossMutation(list1, list2, list3, list4);
        
        // print results
        System.out.println("os1");
        for (int i = 0; i < 10; i++) {
            System.out.print(list3.get(i));
        }
        System.out.println("os2");
        for (int i = 0; i < 10; i++) {
            System.out.print(list4.get(i));
        }
    }
    
    public static void crossMutation(List<Integer> list1, List<Integer> list2, List<Integer> list3, List<Integer> list4) {
        int startpos = (int) (Math.random() * 10);
        System.out.println("startpos: " + startpos);
        int endpos = (int) (Math.random() * 10);
        System.out.println("endpos: " + endpos);
        if (endpos <= startpos) {
            int temp = endpos;
            endpos = startpos;
            startpos = temp;
        }
        // mutation
        for (int i = 0; i <= endpos - startpos; i++) {
            list3.add(startpos + i, list1.get(endpos - i)); // 3 inherit from 1
            list4.add(startpos + i, list2.get(endpos - i)); // 4 inherit from 2
        }
        
        // cross 3 with 2
        // cross 4 with 1
        // delete elements
        for (int i = startpos; i <= endpos; i++) {
            list1.remove(list4.get(i));
            list2.remove(list3.get(i));
        }
        
        // push
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
        
		for (int i = 0; i < list1.size(); i++) {
			s1.push(list1.get(i));
			s2.push(list2.get(i));
		}

        
        for (int i = 0; i < startpos; i++) {
            list3.set(i, s2.pop());  // cross with 2
            list4.set(i, s1.pop());  // cross with 1
        }
        
        //hardcode 10 here
        for (int i = endpos + 1; i < 10; i++) {
            list3.set(i, s2.pop());
            list4.set(i, s1.pop());
        }
        
        // trim the size of list 3 and 4
        if (list3.size() > 10) {
            list3 = list3.subList(0, 9);
        }   
        
        if (list4.size() > 10) {
            for (int i = 10; i < list4.size(); i++) {
                list4.remove(i);
            }
        }
    }
}