class Solution {
    private boolean search(int[]arr , int target){
        int left=0, right=arr.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid]==target){
                return true;
            }else if(arr[mid]> target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] m: matrix){
            if(target>=m[0] && target<=m[m.length-1]){
                return search(m, target);

            }
        }
        return false;
    }
}