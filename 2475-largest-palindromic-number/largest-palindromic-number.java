class Solution {
    public String largestPalindromic(String s) {
        int[] nums = new int[10];
        for(char c : s.toCharArray()){
            nums[c-'0']++;
        }
        StringBuilder sb = new StringBuilder();
        int maxi=-1;
        for(int i=9;i>=0;i--){
            if(nums[i]>0){
                while(nums[i]>=2){
                    if(i==0 && sb.length()==0){
                        break;
                    }
                    sb.append(i);
                    nums[i]-=2;
                }
            }
        }
        for(int i=9;i>=0;i--){
            if(nums[i]>0){
                maxi=i;
                break;
            }
        }
        if(maxi==-1){
            return sb.toString() + sb.reverse().toString();
        }
        return sb.toString() +maxi+ sb.reverse().toString();
    }
}