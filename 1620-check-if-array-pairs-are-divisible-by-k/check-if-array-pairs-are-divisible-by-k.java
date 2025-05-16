class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] freq = new int[k];
        for(int i=0;i<arr.length;i++){
            int x = ((arr[i]%k)+k)%k;
            freq[x]++;
        }
        for(int i=1;i<k;i++){
            if(freq[i]!=freq[k-i])
                return false;
        }
        return freq[0]%2==0;

    }
}