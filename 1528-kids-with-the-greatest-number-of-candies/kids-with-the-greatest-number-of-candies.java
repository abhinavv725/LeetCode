class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();
        System.out.println(max);
        
        int n=candies.length;
        List<Boolean> ans = new ArrayList<>(); 
        for(int i=0;i<n;i++){
            ans.add(candies[i]+extraCandies>=max?true:false);
            
        }
        return ans;
        
    }
}