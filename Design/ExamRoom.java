import java.util.*;
public class ExamRoom {
    public static void main(String args[]) {
        System.out.println("Welcome to exam room!");
        ExamRoom er = new ExamRoom(10);
        System.out.println("Seat for the first student is: " + er.seat());
        System.out.println("Seat for the second student is: " + er.seat());
        System.out.println("Seat for the third student is: " + er.seat());
        //System.out.println("Seat for the fourth student is: " + er.seat());
        er.leave(0);
        er.leave(4);
        System.out.println("Seat for the fifth after 0,4 left is: " + er.seat());
    }
    
    // data fields
    TreeSet<Integer> students;
    int N;
    
    public ExamRoom(int N) {
        this.students = new TreeSet<>();
        this.N = N;
    }
    
    public int seat() {
        int student = 0;
        // if there is already student seat
        if (students.size() > 0) {
            Integer prev = null;
            // to get the first dist to prevent that
            // the first dist is the largest.
            int dist = students.first();
            for (Integer s : students) {
                if (prev != null) {
                    int tp = (s - prev) / 2;
                    if (tp > dist) {
                        student = prev + tp;
                        dist = tp;
                    }
                }
                prev = s;
            }
            // check edge case when largest distance is
            // from the end to last
            if (N - 1 - students.last() > dist) {
                student = N - 1;
            }
        }
        students.add(student);
        return student;
    }
    
    public void leave(int n) {
        students.remove(n);
    }
}