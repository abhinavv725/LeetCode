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
    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null)
            return null;
        ListNode hare=head, tort=head.next;
        while(tort.next!=null && tort.next.next!=null){
            
            hare=hare.next;
            tort=tort.next.next;
        }
        hare.next=hare.next.next;
        return head;
        
    }
}