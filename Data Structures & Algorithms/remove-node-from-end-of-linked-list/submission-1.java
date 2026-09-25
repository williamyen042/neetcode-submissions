/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode lP = head;
        ListNode rP = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for(int i = 0; i < n; i++) {
            if(rP == null) {
                return null;
            }
            rP = rP.next;
        }
        while(lP != null) {
            if(rP == null) {
                //current node is the one we need to remove, set prev.next = curr.next, then remove current
                prev.next = lP.next;
                return dummy.next;
            } else {
                prev = lP;
                lP = lP.next;
                rP = rP.next;
            }
        }
        return null;
    }
}
