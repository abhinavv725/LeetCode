
class Solution:
    def mergeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        curr=head
        temp_sum=0
        start_count=False
        
        new=ListNode()
        prev=new
        
        while(curr):
            if(curr.val==0):
                temp_sum=0
            else:
                temp_sum+=curr.val
                if(curr.next and curr.next.val==0):
                    prev.next=ListNode(temp_sum)
                    prev=prev.next
            curr=curr.next
        return new.next
            
                
            
        