class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);

        int i=2, n=nums.length;
        List<int[]> ans = new ArrayList<>();
        while(i<nums.length){
            int a = nums[i];
            int b= nums[i-1];
            int c = nums[i-2];
            if(a-c<=k){
                ans.add(new int[] {c,b,a});
                i+=3;
            }else{
                i++;
            }
        }
        int[][] arr = ans.toArray(new int[0][]);
        if(arr.length==n/3) return arr;
        return new int[][] {};
    }
}