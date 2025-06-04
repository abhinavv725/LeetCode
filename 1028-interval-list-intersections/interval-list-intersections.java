class Solution {
    public int[][] intervalIntersection(int[][] first, int[][] second) {
        List<int[]> ans = new ArrayList<>();
        int i=0, j=0;
        while(i<first.length && j<second.length){
            int[] f= first[i], s = second[j];
            int start = Math.max(f[0], s[0]);
            int end = Math.min(f[1], s[1]);
            if(start<=end){
                ans.add(new int[] {start, end});
            }
            if(f[1]<s[1]){
                i++;
            }else{
                j++;
            }
        }


        return ans.toArray(new int[ans.size()][]);
    }
}