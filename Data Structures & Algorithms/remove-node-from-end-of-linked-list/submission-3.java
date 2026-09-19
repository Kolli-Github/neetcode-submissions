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
       int tot = 0;
       ListNode curr = head;
       while(curr!=null){
        tot=tot+1;
        curr = curr.next;
       }
       int rem = tot-n;
       if(tot == 1){
        return null;
       }
       if(rem == 0){
        head = head.next;
        return head;
       }
       ListNode prev = null;
       ListNode next = null;
       curr = head;
       int c = 0;
       while(c<rem){
        next = curr.next;
        c++;
        prev = curr;
        curr = next;
       }
       next = curr.next;
       curr.next = null;
       prev.next = next;


    return head;
    }
}
