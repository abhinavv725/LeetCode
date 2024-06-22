class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        cnt,i=0,0
        while(i<len(nums)):
            if(nums[i]==0):
                cnt+=1
                nums.pop(i)
            else:
                i+=1
        print(cnt)
        for i in range(cnt):
            nums.append(0)
        
        