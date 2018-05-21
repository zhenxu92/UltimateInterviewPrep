import java.util.*;
public class HashNodeMap {
    private ArrayList<HashNode> list;
    private int size;
    private int numBackets;
    
    public HashNodeMap() {
        size = 0;
        numBackets = 10;
        list = new ArrayList<HashNode>();
        
        for (int i = 0; i < numBackets; i++) {
            list.add(null);
        }
        
    }
    
    public int hashFunc(int key) {
        return key % numBackets;
    }
    
    public void add(int key, int val) {
        int index = this.hashFunc(key);
        HashNode head = list.get(index);
        while (head != null) {
            if (head.key == key) {
                head.value = val;
                return;
            }
            head = head.next;
        }
        
        size++;
        head = list.get(index);
        HashNode node = new HashNode(key, val);
        node.next = head;
        list.set(index, node);
        
        // load factor 
        // add code to complete load factor here
    }
    
    public int get(int key) {
        int index = this.hashFunc(key);
        HashNode head = list.get(index);
        while (head != null) {
            if (head.key == key) {
                return head.value;
            }
            head = head.next;
        }
        return -1;
    }
    
}