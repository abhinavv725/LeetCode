class Solution {
    private boolean willMeet(int a, int b, int[][] arr, int target){
        double tl = (double)(target-arr[b][0])/arr[b][1];
        double tf = (double)(target-arr[a][0])/arr[a][1];

        return tf<=tl;
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int fleet=1, n = position.length;
        int[][] arr= new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=position[i];
            arr[i][1]=speed[i];
        }
        Arrays.sort(arr, (a,b)->Integer.compare(a[0], b[0]));
        int lastCar = n-1;
        for(int i=n-2;i>=0;i--){
            if(!willMeet(i,lastCar, arr, target)){
                fleet++;
                lastCar = i;
            }
        }

        return fleet;
    }
}