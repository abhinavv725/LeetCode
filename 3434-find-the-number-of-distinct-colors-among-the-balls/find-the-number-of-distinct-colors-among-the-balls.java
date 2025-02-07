class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> ballMap = new HashMap<>();
        HashMap<Integer, Integer> colorMap = new HashMap<>();
        int[] ans = new int[queries.length];
        int distinctColors=0;
        for(int i=0;i<queries.length;i++){
            int ball = queries[i][0];
            int newColor = queries[i][1];

            if(ballMap.containsKey(ball)){
                int oldColor = ballMap.get(ball);
                colorMap.put(oldColor, colorMap.get(oldColor)-1);

                if(colorMap.get(oldColor)==0){
                    colorMap.remove(oldColor);
                    distinctColors--;
                }
            }
            ballMap.put(ball, newColor);
            colorMap.put(newColor, colorMap.getOrDefault(newColor,0)+1);

            if(colorMap.get(newColor)==1)
                distinctColors++;
            ans[i]=distinctColors;

        }
        return ans;
    }
}