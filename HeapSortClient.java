public class HeapSortClient {
    public static void main(String args[]) {
        HeapSort hs = new HeapSort();
        hs.insert(1);
        hs.insert(13);
        hs.insert(100);
        hs.insert(3);
        hs.insert(2);
        System.out.println(hs.toString());
        int[] arr = new int[10];
        for(int i = 10; i > 0; i--) {
            arr[10 - i] = i;
        }
        HeapSort hs2 = new HeapSort(arr);
        System.out.println(hs2.toString());
        System.out.println(hs2.deleteMin());
        System.out.println(hs2.toString());
        int[] sortedArray = hs2.sort();
        
    }
}