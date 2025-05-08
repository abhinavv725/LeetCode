class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] count = new int[k];
        for(int i=0;i<arr.length;i++){
            int x = arr[i]%k;
            if(x<0)
                x+=k;
            count[x]++;
        }
        if(count[0]%2!=0)
            return false;
        for(int i=1;i<k;i++){
            if(count[i]!=count[k-i])
                return false;
        }
        return true;
    }
}