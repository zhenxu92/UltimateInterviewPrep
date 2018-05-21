public class testArr {
    public static void main(String args[]) {
        int[] arr = new int[10];
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        // proved that arr are initialized with all 0s
        // and it is printable
        System.out.println();
        
        int[] arr2 = new int[10];
        for(int i = 0; i < arr2.length; i++) {
            arr2[i] = i;
        }
        int[] arr3 = new int[5];
        System.arraycopy(arr2, 2, arr3, 1, 5);
        for(int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
        // ArrayIndexOutOfBoundsException is thrown,
        // this method, arraycopy, cannot be applied to 
        // those arrays which their sizes are smaller 
        // than the copyFrom arrays.
    }
}