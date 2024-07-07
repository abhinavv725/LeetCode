class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans=0;
        while(numBottles>=numExchange){
            
            int temp=(numBottles)/numExchange; // store the bottles we can drink
            ans+=(temp*numExchange);  // Add all the bottles in ans we can drink
            numBottles-=(temp*numExchange); //Remove the bottles we have finished
            numBottles +=temp; // Add extra bottles we get in numsBotles
            
        }
        
        return ans+numBottles;
        
        
    }
}