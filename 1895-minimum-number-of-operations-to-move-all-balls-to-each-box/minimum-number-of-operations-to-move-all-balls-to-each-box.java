class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int[] ans= new int[n];
        List<Integer> ind = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(boxes.charAt(i)=='1'){
                ind.add(i);
            }
        }
        int m=ind.size();
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<m;j++){
                count+= (Math.abs(ind.get(j)-i));
            }
            ans[i]=count;
        }
        return ans;
    }
}