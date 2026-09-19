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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;
        while(temp !=null){
            ListNode kthNode = findKthNode(temp,k-1);
            if(kthNode==null){
                if(prevNode!=null){
                    prevNode.next = temp;
                }
                break;
            }
            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            ListNode newHead = reverse(temp);
            if(temp == head){
                head = kthNode;
            }
            else{
                prevNode.next = kthNode;
            }
            prevNode = temp;
            temp = nextNode;

        }
        return head;
    }

    public ListNode findKthNode(ListNode temp,int k){
        ListNode curr = temp;
        while(curr!=null && k>0){
            curr=curr.next;
            k--;
        }
        return curr;
    }

    public ListNode reverse(ListNode start){
        ListNode prev = null;
        ListNode nxt = null;
        ListNode curr = start;
        while(curr!=null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
}
