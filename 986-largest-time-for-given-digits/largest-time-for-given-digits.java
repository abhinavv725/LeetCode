class Solution {
    String res="";
    private boolean isValid(String s){
        String[] parts = s.split(":");
        int hours = Integer.parseInt(s.substring(0, 2));
        int min = Integer.parseInt(s.substring(2));
        return hours<=23 && min<=59;
    }
    private String makeTime(String s){
        return s.substring(0, 2)+":"+s.substring(2, 4);
    }
    private boolean dfs(int[] nums, boolean[] used, String parts){
        if(parts.length()==4){
            if(isValid(parts)){
                res=parts;
                return true;
            }return false;
        }
        for(int i=0;i<4;i++){
            if(!used[i]){
                used[i]=true;
                if(dfs(nums, used, parts+nums[i]))
                    return true;
                used[i]=false;
            }
        }
        return false;
    }
    public String largestTimeFromDigits(int[] arr) {
        Arrays.sort(arr);
        for(int i=0, j=3;i<j;i++, j--){
            int t = arr[i];
            arr[i]=arr[j];
            arr[j]=t;
        }
        dfs(arr, new boolean[4], "");
        return res.equals("") ?"": makeTime(res);
    }
}