class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length-1;

        while(start<end){
            int mid = (start+end)/2;
            if(arr[mid+1]>arr[mid]){
                start=mid+1;
            }else
                end=mid;
        }
        return start;
    }
}