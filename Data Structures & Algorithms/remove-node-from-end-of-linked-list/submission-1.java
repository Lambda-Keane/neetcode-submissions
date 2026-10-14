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
        int count = 1;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            count++;
        }
        count -= n;
        ListNode p = null;
        node = head;
        while (count != 1) {
            p = node;
            node = node.next;
            count--;
        }
        if (p == null) head = head.next;
        else p.next = node.next;
        return head;
    }
}
