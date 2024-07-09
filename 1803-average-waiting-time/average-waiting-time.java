class Solution {
    public double averageWaitingTime(int[][] customers) {
        int time=0,i=0;
        double ans=0;
        
        
        while(i<customers.length){
            
            if(customers[i][0]<=time){
                time+=customers[i][1];
                ans+=(time-customers[i][0]);
                // System.out.println(time-customers[i][0]);
                i+=1;
            }else{
                time++;
            }
        }
        return (double)ans/customers.length;
        
    }
}