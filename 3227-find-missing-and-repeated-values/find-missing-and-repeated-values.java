class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int a=0, b=0, n= grid.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map.containsKey(grid[i][j])){
                    a=grid[i][j];
                    map.put(a, 2);
                }else{
                    map.put(grid[i][j], 1);
                }
            }
        }
        for(int i=1;i<=n*n;i++){
            if(!map.containsKey(i)){
                return new int[] {a, i};
            }
        }
        return new int[] {a,b};
    }
}