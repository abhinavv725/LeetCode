class Solution {
    public int minMaxDifference(int num) {
        char[] max = String.valueOf(num).toCharArray();
        char[] min = String.valueOf(num).toCharArray();
        char tobeReplaced = '0';
        for(int i=0;i<max.length;i++){
            if(max[i]!='9'){
                tobeReplaced=max[i];
                break;
            }
        }
        for(int i=0;i<max.length;i++){
            if(max[i]== tobeReplaced){
                max[i] ='9';
            }
        }

        for(int i=0;i<min.length;i++){
            if(min[i]!='0'){
                tobeReplaced=min[i];
                break;
            }
        }
        for(int i=0;i<min.length;i++){
            if(min[i]== tobeReplaced){
                min[i] ='0';
            }
        }
        String maxi = new String(max);
        String mini = new String(min);
        return Integer.parseInt(maxi)-Integer.parseInt(mini);
    }
}