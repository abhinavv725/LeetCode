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
        ListNode dummOdd = new ListNode(-1);
        ListNode dummEven = new ListNode(-1);
        ListNode currOdd = dummOdd, currEven = dummEven, curr = head;
        int i=1;
        while(curr!=null){
            if(i%2==0){
                currEven.next=curr;
                currEven=currEven.next;

            }else{
                currOdd.next=curr;
                currOdd=currOdd.next;
            }
            curr=curr.next;
            i++;
        }
        currEven.next=null;
        currOdd.next=null;
        currOdd.next=dummEven.next;


        return dummOdd.next;
        
    }
}