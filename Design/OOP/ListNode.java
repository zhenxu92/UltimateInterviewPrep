public class ListNode {
    public int val;
    public ListNode next;
    
    public ListNode() {
    
    }
    
    public ListNode(int val) {
        this.val = val;
    }
    
    public ListNode(ListNode next) {
        this.next = next;
    }
    
    public ListNode(ListNode next, int val) {
        this.val = val;
        this.next = next;
    }
}