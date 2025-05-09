class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = Arrays.stream(cardPoints).sum();
        int n=cardPoints.length;
        if (k == n) return sum;
        
        int window = n-k;
        int windowSum=0;
        for(int i=0;i<window;i++){
            windowSum+=cardPoints[i];
        }
        int miniWindow=windowSum;
        for(int i=window;i<n;i++){
            windowSum+= cardPoints[i] - cardPoints[i-window];
            miniWindow = Math.min(miniWindow, windowSum);
        }


        return sum-miniWindow;
    }
}