class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int a1=0, a2=0, s1=0, s2=0;
        for(int n: nums){
            s1+=n;
            a1 =Math.max(a1, s1);
            s1=Math.max(s1, 0);
        }
        for(int n: nums){
            s2+=n;
            a2 =Math.min(a2, s2);
            s2=Math.min(s2, 0);
        }
        return Math.max(a1, Math.abs(a2));
    }
}