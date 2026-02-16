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
        ListNode ans = new ListNode(0);
        ListNode t = ans;
        
        boolean carry=false;
        while(l1!=null || l2!=null){
            int temp = (carry) ?1 :0;
            carry = false;
            if(l1!=null){
                temp+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                temp+=l2.val;
                l2=l2.next;
            }
            if(temp>=10){
                temp-=10;
                carry=true;
            }
            ans.next = new ListNode(temp);
            ans=ans.next;

        }
        if(carry){
            ans.next = new ListNode(1);
        }

        return t.next;
    }
}