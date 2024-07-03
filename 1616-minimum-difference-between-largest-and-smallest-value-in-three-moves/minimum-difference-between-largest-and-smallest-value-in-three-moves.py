class Solution:
    def minDifference(self, nums: List[int]) -> int:
        n=len(nums)
        if(n<=4):
            return 0
        
        small_four = sorted(heapq.nsmallest(4,nums))
        large_four = sorted(heapq.nlargest(4,nums))
        
        mi = float("inf")
        
        for i in range(4):
            mi=min(mi,large_four[i]-small_four[i])
        return mi
            

        