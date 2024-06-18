class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        map={}
        ma=0
        checked=[]
        for i in nums:
            map[i]=True
        for i in nums:
            temp=i-1
            if(temp in map):
                pass
            
            else:
                count=0
                while(i  in map):
                    i+=1
                    count+=1
                
                ma=max(ma,count)
                    
        return ma