class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total= 0, res=0;
        int sum_gas = Arrays.stream(gas).sum(); 
        int sum_cost = Arrays.stream(cost).sum(); 
        if(sum_cost>sum_gas)
            return -1;

        for(int i=0;i<gas.length;i++){
            total += (gas[i]-cost[i]);
            if(total<0){
                total = 0;
                res = i+1;
            }
        }    
        return res;
    }
}