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
    public ListNode oddEvenList(ListNode head) {
        ListNode dummyOdd = new ListNode(-1);
        
        ListNode dummyEven = new ListNode(-1);
        ListNode curr = head, currEven =dummyEven, currOdd = dummyOdd;
        int i=1;
        while(curr!=null){
            if(i%2==0){
                currEven.next = curr;
                currEven = currEven.next;

            }else{
                currOdd.next = curr;
                currOdd = currOdd.next;
            }
            i++;
            curr=curr.next;
        }
        currEven.next=null;
        currOdd.next =  dummyEven.next;
        return dummyOdd.next;
    }
}