class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i=0, j=0;
        List<int[]> ans = new ArrayList<>();
        while(i<firstList.length && j<secondList.length){
            int[] first = firstList[i];
            int[] second = secondList[j];

            int pehla = Math.max(first[0], second[0]);
            int doosra = Math.min(first[1], second[1]);
            if(pehla<=doosra){
                ans.add(new int[] {pehla, doosra});
            }
            if(first[1]<second[1]){
                i++;
            }else {
                j++;
            }

        }
        return ans.toArray(new int[0][]);
    }
}