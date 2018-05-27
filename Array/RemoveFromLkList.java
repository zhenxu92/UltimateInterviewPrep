/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveFromLkList {
    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        deleteDuplicates(head);    
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode myHead = new ListNode(9527);
        ListNode slow = myHead;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            if (fast.val != fast.next.val) {
                fast = fast.next;
                slow = slow.next;
            } else {
                while (fast != null && fast.next != null && fast.val == fast.next.val) {
                    fast = fast.next;
                }
                slow.next = fast.next;
                fast = slow.next;                
            }
        }
        return myHead.next;
    }
}