/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveFromLinkedList {
    public static void main(String args[]) {
        int[] arr = new int[]{1,2,6,3,4,5,6};
        ListNode head = new ListNode(9527);
        ListNode cur = head;
        for (int i = 0; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        removeElements(head.next, 6);
    }
    
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode myHead = new ListNode(9527);
        ListNode cur = myHead;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
                continue;
            }
            cur = cur.next;
        }
        return myHead.next;
    }
}