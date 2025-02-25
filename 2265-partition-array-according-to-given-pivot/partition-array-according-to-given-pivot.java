class Solution {
    public int[] pivotArray(int[] a, int pivot) {
        List<Integer> less = new ArrayList<>();
        List<Integer> more = new ArrayList<>();
        int n = a.length;
        int countPivot=0;
        for(int i=0;i<n;i++){
            if(a[i]<pivot){
                less.add(a[i]);
            }else if (a[i]>pivot){
                more.add(a[i]);
            }else{
                countPivot++;
            }
        }
        int[] ans=new int[n];
        int index=0;
        for(int i=0;i<less.size();i++){
            ans[index++]=less.get(i);
        }
        for(int i=0;i<countPivot;i++){
            ans[index++] = pivot;
        }
         for(int i=0;i<more.size();i++){
            ans[index++]=more.get(i);
        }
        return ans;
    }
}