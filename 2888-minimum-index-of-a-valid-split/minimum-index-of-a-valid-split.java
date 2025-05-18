class Solution {
    public int minimumIndex(List<Integer> nums) {
        int count=0, candidate=-1;
        for(int n: nums){
            if(count==0)
                candidate=n;
            count += (n==candidate) ? 1:-1; 
        }
        count=0;
        for(int n: nums){
            count += (n==candidate) ?1:0;
        }
        int currCount = 0;
        for(int i=0;i<nums.size();i++){
            if(nums.get(i)==candidate){
                currCount++;
                int secondHalf = count-currCount;
                if(currCount *2>(i+1) && secondHalf *2> (nums.size()-i-1)){
                    return i;
                }
            }
        }
        return -1;
    }
}