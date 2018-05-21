public class FindKthFromEnd {
    public static void main(String args[]) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        System.out.print(0);
        for (int i = 0; i < 1; i++) {
            cur.next = new ListNode(i + 1);
            cur = cur.next;
            System.out.print(i + 1);
        }
        System.out.println();
        // return the 3rd node from the end
        System.out.println(kthElement(head, 1));
    }
    
    /*
     * return the nth element from the end in a linked list.
     * 
     * @param head, head of your input list. 
     * @param n, index n to indicate nth element from the end. If 
     * the size of the list is smaller than n, return the first 
     * element in the list.
     * @throws IllegalArgumentException if the input element is null.
     * @return the nth element from the end
     */
    
    private static int kthElement(ListNode head, int n) {
        if (head == null) throw new IllegalArgumentException("ListNode is empty");
        ListNode fast = head;
        ListNode slow = head;
        int k = n;
        while (fast != null) {
            if (k <= 0) {
                slow = slow.next;
            }
            k--;
            fast = fast.next;
        }
        return slow.val;
    }
}