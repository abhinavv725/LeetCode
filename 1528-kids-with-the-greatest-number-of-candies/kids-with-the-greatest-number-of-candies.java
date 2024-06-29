class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = -1;
        int n=candies.length;
        for(int i=0;i<n;i++){
            max=Math.max(max,candies[i]);
            
        }
        
        
        List<Boolean> ans = new ArrayList<>(); 
        for(int i=0;i<n;i++){
            ans.add(candies[i]+extraCandies>=max?true:false);
            
        }
        return ans;
        
    }
}