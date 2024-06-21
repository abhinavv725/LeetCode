class Solution:
    def findMin(self, nums: List[int]) -> int:
        n=len(nums)-1
        l,r=0,n
        
        while(l<r):
            mid=(l+r)//2
            if(nums[mid]>nums[r]):
                l=mid+1
            else:
                r=mid
        return nums[l]
            
                
        