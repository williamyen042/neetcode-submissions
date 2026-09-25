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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode prev = dummy;
        ListNode left = l1;
        ListNode right = l2;
        boolean carry = false;
        while(left != null && right != null) {
            int sum = left.val + right.val;
            if(carry) {
                sum++;
            }
            if(sum/10 > 0) {
                carry = true;
                sum %= 10;
            } else {
                carry = false;
            }
            left = left.next;
            right = right.next;
            curr.next = new ListNode(sum);
            curr = curr.next;
        }
        //check which list ran out of numbers
        if(left == null) {
            //calculate right
            while(right != null) {
                int sum = right.val;
                if(carry) {
                    sum++;
                }
                if(sum / 10 > 0) {
                    carry = true;
                    sum %= 10;
                } else {
                    carry = false;
                }
                right = right.next;
                curr.next = new ListNode(sum);
                curr = curr.next;
            }
        } else if (right == null) {
            //calculate right
            while(left != null) {
                int sum = left.val;
                if(carry) {
                    sum++;
                }
                if(sum / 10 > 0) {
                    carry = true;
                    sum %= 10;
                } else {
                    carry = false;
                }
                left = left.next;
                curr.next = new ListNode(sum);
                curr = curr.next;
            }
        }
        if(carry) {
            curr.next = new ListNode(1);
            curr = curr.next;
        }
        return dummy.next;

    }
    //l1 and l2 ar
}
