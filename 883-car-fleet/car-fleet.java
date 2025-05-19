class Solution {
    private boolean checkIfCollide(int[] a, int[] b, int target){
        double a_time = (double)(target-a[0])/a[1];
        double b_time =  (double)(target-b[0])/b[1];
        return b_time<=a_time;
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pos = new int[position.length][2];
        for(int i=0;i<position.length;i++){
            pos[i][0]=position[i];
            pos[i][1] = speed[i];
        }
        Arrays.sort(pos, (a,b) -> Integer.compare(a[0], b[0]));
        int n = position.length;
        int fleet=1;
        int[] lead = pos[n-1];
        for(int i=n-2;i>=0;i--){
            int[] car = pos[i];
            if(!checkIfCollide(lead, car, target)){
                fleet++;
                lead = car;
            }
        }
        return fleet;
    }
}