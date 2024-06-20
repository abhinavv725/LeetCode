class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        l,r=0,len(nums)-1
        
        while(l<=r):
            mid=(l+r)//2
            if(l==r):
                return nums[l]
            
            if(mid%2==1):
                if(nums[mid-1]==nums[mid]):
                    l=mid+1
                else:
                    r=mid
            else:
                if(nums[mid+1]==nums[mid]):
                    l=mid+1
                else:
                    r=mid
        return -1
                    
                
                    
                    
                
        