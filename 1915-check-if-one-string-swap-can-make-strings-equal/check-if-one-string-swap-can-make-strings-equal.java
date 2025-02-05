class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2))
            return true;
        if(s1.length()!=s2.length())
            return false;

        int nums=0;
        int first=-1, second=-1;
        for(int i=0;i<s2.length();i++){
            if(s1.charAt(i)==s2.charAt(i)){
                continue;
            }else{
                nums++;
                if(nums>2)
                    return false;
                if(first==-1){
                    first=i;
                }else{
                    second=i;
                }

            }
        }
        return nums==2 && 
        s1.charAt(first)==s2.charAt(second) && 
        s1.charAt(second)==s2.charAt(first);

    }
}