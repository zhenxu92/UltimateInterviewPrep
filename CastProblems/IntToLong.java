public class IntToLong {
    public static void main (String args[]) {
        int x = 5;
        Long y = new Long(x);
        Long z = Long.valueOf(6);   // test Long object converting
        System.out.println(y);      
        System.out.println(z);
        String str = Long.toBinaryString(y);    // test converting long to binary string
        System.out.println(str);
        int in = ~x;
        System.out.println(in);
        String intstr = Integer.toBinaryString(in);
        System.out.println(intstr);
        int start = 0;
        for (int i = 0; i < intstr.length(); i++) {
            if (intstr.charAt(i) == '0') {
                start = i;
            }
        }
        int diff = intstr.length() - start - 1;
        int[] bitcode = new int[diff];
        for (int i = 0; i < bitcode.length; i++) {
            bitcode[i] = Character.getNumericValue(intstr.charAt(start + i));
        }
        for(int i = 0; i < bitcode.length; i++) {
            System.out.print(bitcode[i]);
        }
        System.out.println();
        int answer = BitToInt(bitcode);
        System.out.println(answer);
    }
    
    public static int BitToInt(int[] bitArray) {
        int answer = 0;
        for (int i = 0; i < bitArray.length; i++) {
            answer+= Math.pow(2, bitArray[i]);
        }
        return answer;
    }
}