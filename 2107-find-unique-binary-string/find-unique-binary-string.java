class Solution {
    private boolean check(String[] nums, String ans){
        for(String num: nums){
            if(ans.equals(num)){
                return false;
            }
        }
        return true;
    }
    private boolean perm(StringBuilder sb, String[] nums, int i, int n){
        if(i>=n)
            return false;
        sb.setCharAt(i, '1');
        if(check(nums, sb.toString()) || perm(sb, nums, i+1, n)){
            return true;
        }
        sb.setCharAt(i, '0');
        return false;
    }
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append('0');
        }
        perm(sb, nums, 0, n);
        return sb.toString();

    }
}