import java.util.*;
public class SchoolSeatArray {
    public static void main(String args[]) {
        List<Integer> schoolSeatsArray = new ArrayList<>();
        schoolSeatsArray.add(1);
        schoolSeatsArray.add(1);
        schoolSeatsArray.add(1);
        schoolSeatsArray.add(1);
        List<Integer> studentScoreArray = new ArrayList<>();
        studentScoreArray.add(980);
        studentScoreArray.add(980);
        studentScoreArray.add(980);
        studentScoreArray.add(980);
        List<List<Integer>> studentSchoolPreferencesArray = new ArrayList<>();
        List<Integer>
        List<Integer> res = allocateSchools(schoolSeatsArray, studentScoreArray, studentSchoolPreferencesArray);
        System.out.println(res.toString());
    }
    static List<Integer> allocateSchools(List<Integer> schoolSeatsArray, List<Integer> studentScoreArray, List<List<Integer>> studentSchoolPreferencesArray) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(0);
        if(schoolSeatsArray == null || schoolSeatsArray.size() == 0 
           || studentScoreArray == null || studentScoreArray.size() == 0 
           || studentSchoolPreferencesArray == null || studentSchoolPreferencesArray.size() == 0){
            
            return result;
        }
        HashMap<Integer, List<List<Integer> > > map = new HashMap<>();
        for(int i = 0; i < studentScoreArray.size(); i++){
            int score = studentScoreArray.get(i);
            if(!map.containsKey(score)){
                map.put(score, new ArrayList<List<Integer>>());
            }
            map.get(score).add(studentSchoolPreferencesArray.get(i));
        }
        
        Collections.sort(studentScoreArray);
        boolean[] isAssigned = new boolean[studentScoreArray.size()];
        for(int i =0; i < studentScoreArray.size(); i++){
            List<List<Integer>> lists = map.get(studentScoreArray.get(i));
            for(List<Integer> list : lists){
                for(int school : list){
                    if(schoolSeatsArray.get(school) > 0){
                        int count = schoolSeatsArray.get(school) - 1;
                        schoolSeatsArray.set(school, count);
                        isAssigned[i] = true;
                        break;
                    }
                }
            }
        }
       
        int count = 0;
        for(int i = 0; i < schoolSeatsArray.size(); i++){
            count += schoolSeatsArray.get(i);
        }
        result.set(0,count);
        count = 0;
        for(int i = 0; i < studentScoreArray.size(); i++){
            if(!isAssigned[i]){
                count++;
            }
        }
        result.set(1,count);
        return result;
    }
}