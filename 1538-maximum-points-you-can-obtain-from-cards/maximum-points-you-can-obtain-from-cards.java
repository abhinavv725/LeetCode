class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int totalSum = 0;
        for(int point: cardPoints){
            totalSum+=point;
        }
        int window = cardPoints.length-k, sum=0;
        
        for(int start=0;start<window;start++){
            sum+=cardPoints[start];
        }
        int miniSum = sum;
        for(int start=window;start<cardPoints.length;start++){
            sum+=cardPoints[start];
            sum-=cardPoints[start-window];
            miniSum = Math.min(miniSum,sum);
        }


        return totalSum - miniSum;
    }
}