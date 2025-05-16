class Solution {
    public int compress(char[] chars) {
        int l=0, n=1;
        for(int r=1;r<=chars.length;r++){
            if(r==chars.length || chars[r]!=chars[r-1] ){
                
                chars[l]=chars[r-1];
                l++;
                if(n>1){
                    String temp =Integer.toString(n);
                    for(int x=0;x<temp.length();x++){
                        chars[l] = temp.charAt(x);
                        l++;
                    }
                }
                n=1;
            }else{
                n++;
            }
        }
        return l;
    }
}