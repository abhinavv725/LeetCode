class Solution:
    def countKDifference(self, nums: List[int], k: int) -> int:
        map={}
        cnt=0
        for i in range(len(nums)):
            cnt+=map.get(k+nums[i],0) + map.get(nums[i]-k,0)
            
            map[nums[i]]=map.get(nums[i],0)+1
        return cnt