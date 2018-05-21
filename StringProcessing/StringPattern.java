// aba aba aba
// aabacdfddabacdfddabacdfddabacdfddabacdfddbacdfdd
// ababababab
// aabcaabc
// a 
//  a
//   a?
// aa
//   aa?
// aab
//    aab?
// aabc
//     aabc
// pointer = string.length? Yes
// end
// return true;

// aabcaabcaabc l = 12
// patlen = 4
// 12 % 4 == 0;
// 12 / 2 = 6
// aabcaa bcaabc => no
// 12 % 5 != 0;
// 12 % 4 == 0;
// aabc aabc yes
// aabc aabc


public class StringPattern {
    public static void main (String args[]) {
        String str = "aabcaabcabc";
        System.out.println(solution(str));
        
    }
    
    public static boolean solution (String s) {
        int len = s.length();
        for (int i = len / 2; i > 0; i--) {
            if (len % i == 0) {
                int times = len / i;
                int j;
                String str = s.substring(0, i);
                for (j = 0; j < times; j++) {
                    if (!str.equals(s.substring(j*i, j*i + i))) break;
                }
                if (j == times) return true;
            }
        }
        return false;
}
}