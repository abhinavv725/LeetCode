
class Solution {
    
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dumm = new ListNode(-1);
        ListNode curr = dumm;
        while(head!=null){
            if(head.next!=null && head.val==head.next.val){
                int dupli = head.val;
                while(head!=null && head.val == dupli){
                    head=head.next;
                }
                curr.next=head;
            }else{
            curr.next = head;
            curr=curr.next;
                head = head.next;
            }
        }
        return dumm.next;
    }
}