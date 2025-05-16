class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l=0, r= numbers.length-1;
        while(l<=r){
            int a = numbers[l], b = numbers[r];
            if(a+b==target)
                return new int[] {l+1, r+1};
            if(a+b>target){
                r--;
            }else{
                l++;
            }
        }
        return new int[]{-1,-1};
    }
}