
class Solution:
    def nodesBetweenCriticalPoints(self, head: Optional[ListNode]) -> List[int]:
        temp=[]
        
        prev=head
        curr=head.next
        count=2
        while(curr):
            if(curr.next is None):
                if(len(temp)<2):return [-1,-1]
                # elif(len(temp)==1):return [temp[0],temp[0]]
                else:
                    print(temp)
                    mi=float("inf")
                    
                    for i in range(1,len(temp)):
                        mi=min(mi,temp[i]-temp[i-1])
                    
                    return [mi,temp[-1]-temp[0]]
                    
            else:
                if((curr.val>prev.val and curr.val>curr.next.val) or (curr.val<prev.val and curr.val<curr.next.val)):
                    temp.append(count)
            
            prev=curr
            curr=curr.next
            count+=1
        
        
        
        return [-1,-1]
        
        