class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left=0, right=arr.length-1;
        while(left<right){
            int mid = (left+right)/2;
            if(arr[mid]<x){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        int i=left-1;
        int j=left;
        while(k-- >0){
            if(i<0){
                j++;
            }else if(j>=arr.length){
                i--;
            }else if(Math.abs(arr[i]-x)<=Math.abs(arr[j]-x) ){
                i--;
            }else{
                j++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int idx = i+1;idx<j;idx++){
            ans.add(arr[idx]);
        }
        return ans;
    }
}