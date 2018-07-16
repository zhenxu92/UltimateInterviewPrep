/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
// #24
class SwapNodesInPairs {
    public static void main(String args[]) {
        ListNode head = null;
        ListNode cur = null;
        for (int i = 1; i <= 4; i++) {
            if (head == null) {
                head = new ListNode(i);
                cur = head;
            } else {
                cur.next = new ListNode(i);
                cur = cur.next;
            }
        }
        ListNode res = swapPairs(head);
        cur = res;
        while (cur != null) {
            System.out.print(cur.val + ", ");
            cur = cur.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode myHead = new ListNode(9527);
        myHead.next = head;
        ListNode cur = myHead;
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            first.next = second.next;
            cur.next = second;
            second.next = first;
            cur = first;
        }
        return myHead.next;
    }
}