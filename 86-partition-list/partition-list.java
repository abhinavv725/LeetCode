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
    public ListNode partition(ListNode head, int x) {
        ListNode dummyLess = new ListNode(-1);
        ListNode dummyGreat = new ListNode(-1);
        ListNode currS = dummyLess;
        ListNode currG = dummyGreat;
        ListNode curr = head;
        while(curr!=null){
            if(curr.val<x){
                currS.next=curr;
                currS=currS.next;
            }else{
                currG.next=curr;
                currG=currG.next;
            }
            curr=curr.next;
        }
        currG.next=null;
        currS.next=dummyGreat.next;
        return dummyLess.next;
        

    }
}