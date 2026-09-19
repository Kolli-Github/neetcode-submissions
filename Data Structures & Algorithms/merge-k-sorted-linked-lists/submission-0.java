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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        if(lists.length<2){
            return lists[0];
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode list1 = lists[0];
        ListNode list2 = lists[1];

        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                curr.next = list1;
                list1 = list1.next;
            }
            else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if(list1!=null){
            curr.next = list1;
        }
        if(list2!=null){
            curr.next = list2;
        }

        ListNode newList1 = dummy.next;

        for(int i=2;i<lists.length;i++){
            ListNode fake = new ListNode(-1);
            curr = fake;
            ListNode newList2 = lists[i];

            while(newList1!=null && newList2!=null){
                if(newList1.val<=newList2.val){
                    curr.next = newList1;
                    newList1 = newList1.next;
                }
                else{
                    curr.next = newList2;
                    newList2 = newList2.next;
                }
                curr = curr.next;
            }
            if(newList1!=null){
                curr.next = newList1;
            }
            if(newList2!=null){
                curr.next = newList2;
            }
            newList1 = fake.next;
        }
        return newList1;
    }
}
