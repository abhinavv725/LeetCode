class Solution {
    public int integerReplacement(int n) {
        if (n == Integer.MAX_VALUE) return 32;
        int count=0;
        while(n!=1){
            if(n%2==0){
                n /=2;
            }else{
                if(n==3 || n%4==1){
                    n-=1;
                }else{
                    n+=1;
                }
            }
            count++;
        }
        return count;
        
    }
}