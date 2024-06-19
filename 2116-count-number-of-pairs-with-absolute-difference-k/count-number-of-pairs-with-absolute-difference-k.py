class Solution:
    def countKDifference(self, nums: List[int], k: int) -> int:
        map={}
        cnt=0
        for i in range(len(nums)):
            temp=(k+nums[i])
            temp2=(nums[i]-k)
            if(temp in map):
                cnt+=map[temp]
            if(temp2 in map):
                cnt+=map[temp2]
            if(nums[i] not in map):
                map[nums[i]]=1
            else:
                map[nums[i]]+=1
        return cnt