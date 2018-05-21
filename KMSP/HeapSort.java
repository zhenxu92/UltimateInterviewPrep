// Zhen Xu
// HeapSort v 1.0
// This program complete the basic function of sorting using heapsort
// algorithm.

// Heapsort: buildHeap, then deleteMin till everything is dequeued
// buildHeap:
// using an array
import java.util.*;
import org.apache.commons.lang3.ArrayUtils;
public class HeapSort {
    private Edge[] arr;
    private int size;
    private Comparator<Edge> comparator;
    
    // Pre: if there is anything in this structure,
    // calling this constructor will not store any
    // previous data.
    // Post: construct a heap structure
    public HeapSort() {
        size = 0;
        arr = new Edge[100];
    }
    
    // Pre: the other array
    // Construct a heap structure from another array
    public HeapSort(Edge[] other) {
        
        this.arr = new Edge[other.length + 1];
        for(int i = 0; i < other.length; i++) {
            this.arr[i + 1] = other[i];
        }        
        this.size = other.length;
        buildHeap();
    }
    
    // Pre: the heap structure has already been created
    // Post: all data are already in the right order of 
    // a heap
    public void buildHeap() {
        for(int i = size / 2; i > 0; i--) {
            Edge val = arr[i];
            int hole = percolateDown(i, val);
            arr[hole] = val;
        }
        // TODO: restore size of the binary heap        
    }
    
    public void insert(Edge val) {
        if(size == arr.length - 1) {
            resize();
        }
        size = size + 1;
        int hole = percolateUp(size, val);
        arr[hole] = val;   
    }
    
    public Edge deleteMin() {
        if(this.arr.length == 0) {
            throw new IllegalArgumentException();
        }
        Edge ans = arr[1];
        int hole = percolateDown(1, arr[size]);
        arr[hole] = arr[size];
        size = size - 1;
        return ans;
    } 
    
    private int percolateUp(int hole,Edge val) {
        while(hole > 1 && greater(arr[hole/2], val)) {
            arr[hole] = arr[hole/2];
            hole = hole/2;
        }
        return hole;       
    }
    
    private int percolateDown(int hole, Edge val) {
        while(2 * hole <= size) {
            int left = 2 * hole;
            int right = left + 1;
            int target = 0;
            // determine if the index of any child is out of bound
            if(right > size || greater(arr[right], arr[left])) {
                target = left;
            } else {
                target = right;
            }
            if(greater(val, arr[target])) {
                arr[hole] = arr[target];
                hole = target;
            } else {
                break;
            }   
        }
        return hole;
    }
    
    // Pre: the arr must be constructed before this method can be use
    // Post: the size of the array will be doubled afterwards
    public void resize() {
        Edge[] copyArr = new Edge[this.size * 2];
        System.arraycopy(this.arr, 0, copyArr, 0, size);  
        this.arr = copyArr;  
    }
    
    public boolean isEmpty() {
    	return size == 0;
    }
    
    public String toString() {
        String str = "";
        for(int i = 1; i < this.size + 1; i++) {
            str = str + this.arr[i].toString() + " ";
        }
        return str;
    }
    

    
    // Pre: an input of an array consists of all integer numbers.
    // Post: output an array that is in ascending order.
    public Edge[] sort() {
        int n = size;
        Edge[] sorted = new Edge[n];
        for(int i = 1; i < n; i++) {
            this.arr[n + 1 - i] = deleteMin();
        }
        System.arraycopy(this.arr, 1, sorted, 0, n);
        ArrayUtils.reverse(sorted);
        // restore the size of the binary heap
        this.size = n;
        return sorted;
    }
    
    private boolean greater(Edge i, Edge j) {
        if(comparator == null) {
            return ((Comparable<Edge>)i).compareTo(j) > 0;
        } else {
            return comparator.compare(i, j) > 0;
        }
    }
}