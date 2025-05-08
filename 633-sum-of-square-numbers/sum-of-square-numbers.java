class Solution {
    public boolean judgeSquareSum(int c) {
        int start = 0, end = (int) Math.sqrt(c);
        while(start<=end){
            long target = (long)(start*start) + (long)(end*end);
            if(target==c)
                return true;
            else if(target>c){
                end--;
            }else{
                start++;
            }
        }
        return false;
    }
}