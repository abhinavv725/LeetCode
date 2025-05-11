class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a,b)->Integer.compare(a[0],b[0]));
        int i=0;
        List<int[]> arr = new ArrayList<>();
        while(i<meetings.length){
            int[] first = meetings[i];
            int j=i+1;
            while(j<meetings.length && first[1]>=meetings[j][0]){
                first[0] = Math.min(first[0],meetings[j][0] );
                first[1] = Math.max(first[1],meetings[j][1]);
                j++;
            }
            arr.add(first);
            i=j;
        }
        int freedays=0;
        for( i=0;i<arr.size();i++){
            if(i==0){
                freedays += arr.get(i)[0]-1;
            }else{
                freedays+= arr.get(i)[0]-arr.get(i-1)[1]-1;
            }
        }
        freedays+= (days - arr.get(arr.size()-1)[1]);

        return freedays;
    }
}