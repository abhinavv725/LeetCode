class Solution {
    public int lengthOfLastWord(String s) {
        String[] val = s.split(" ");
        
        
        for(int i = val.length-1;i>=0;i--){
            if(val[i].length()!=0)
                return val[i].length();
        }
        return 1;
        
    }
}