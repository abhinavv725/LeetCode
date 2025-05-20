
class Solution {
    private ListNode mergerNodes(ListNode a, ListNode b){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(a!=null && b!=null){
            if(a.val> b.val){
                curr.next = b;
                b=b.next;
            }else{
                curr.next = a;
                a=a.next;
            }
            curr=curr.next;
        }
        if(a!=null){
            curr.next=a;
        }
        if(b!=null){
            curr.next=b;
        }

        return dummy.next;
    }
    private ListNode mergeSort(ListNode head){
        if(head == null || head.next==null)
            return head;
        ListNode slow=head, fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode left=head;
        ListNode right = slow.next;
        slow.next=null;

        left = mergeSort(left);
        right = mergeSort(right);
        return mergerNodes(left, right);
    }
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
}