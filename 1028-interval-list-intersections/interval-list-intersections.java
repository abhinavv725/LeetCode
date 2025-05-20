class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList<>();
        int n = firstList.length, m = secondList.length, i=0, j=0;

        while(i<n && j<m){
            int[] first = firstList[i];
            int[] second = secondList[j];
            int[] curr = new int[2];
            int start = Math.max(first[0], second[0]);
            int end = Math.min(first[1], second[1]);
            if(start<=end){
                ans.add(new int[] {start, end});
            }
            if(second[1]>first[1]){
                i++;
            }else{
                j++;
            }
        }
        return ans.toArray(new int[0][]);
    }
}