
class Solution {
    private ListNode reverse(ListNode l){
        ListNode prev = null;
        while(l!=null){
            ListNode temp = l.next;
            l.next=prev;
            prev=l;
            l=temp;
        }

        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // l1 = reverse(l1);
        // l2 = reverse(l2);
        int carry =0;
        ListNode dummy = new ListNode(-1);
        ListNode curr=dummy;
        while(l1!=null || l2!=null || carry==1){
            int temp = carry;
            carry=0;
            if(l1!=null){
                temp+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                temp+=l2.val;
                l2=l2.next;
            }
            carry = temp/10;
            temp = temp%10;
            curr.next = new ListNode(temp);
            curr=curr.next;
            
        }

        return dummy.next;
    }
}