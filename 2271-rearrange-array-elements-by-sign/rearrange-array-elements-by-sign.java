class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int[] ans =new int[n];
        int index =0;
        Queue<Integer> pos = new LinkedList<>();
        Queue<Integer> neg = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(nums[i]>=0){
                pos.add(nums[i]);
            }else{
                neg.add(nums[i]);
            }
        }
        for(int i=0;i<n;i++){
            if(i%2==0){
                ans[index++] = pos.poll();
            }else{
                ans[index++] = neg.poll();
            }
        }
        return ans;
    }
}