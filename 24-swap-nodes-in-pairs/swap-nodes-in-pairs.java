
class Solution {
    private boolean checkIfNodesExist(ListNode head, int k){
        for(int i=0;i<k;i++){
            if(head==null){
                return false;
            }
            head=head.next;
        }
        return true;
    }
    private ListNode getTheKthNode(ListNode head, int k){
        for(int i=1;i<k;i++){
            head=head.next;
        }
        return head;
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next=prev;
            prev= curr;
            curr=temp;
        }

        return prev;
    }
    private ListNode reverseKgroups(ListNode head, int k){
        if(!checkIfNodesExist(head, k)){
            return head;
        }
        ListNode kthNode = getTheKthNode(head, k);
        ListNode nextGroup = kthNode.next;
        kthNode.next = null;
        ListNode newHead = reverse( head);
        head.next=reverseKgroups(nextGroup, k);
        return newHead;



    }
    public ListNode swapPairs(ListNode head) {
        return reverseKgroups(head, 2);
    }
}