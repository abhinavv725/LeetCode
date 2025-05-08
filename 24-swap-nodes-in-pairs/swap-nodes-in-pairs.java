
class Solution {
    private ListNode reverseInK(ListNode head, int k){
        if(head==null || head.next==null || k==1)
            return head;
        
        ListNode slow=head, fast=head;
        for(int i=0;i<k;i++){
            if(fast==null)
                return head;
            fast=fast.next;
        }
        ListNode curr=slow, prev=slow, next=slow;
        while(curr!=fast){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
         slow.next = reverseInK(fast, k);
         return prev;
    }
    public ListNode swapPairs(ListNode head) {
        return reverseInK(head, 2);
    }
}