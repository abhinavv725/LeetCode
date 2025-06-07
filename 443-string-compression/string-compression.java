class Solution {
    public int compress(char[] chars) {
        int l=0;
        int num=1, n=chars.length;
        for(int r=1;r<=n;r++){
            if(r==n || chars[r]!=chars[r-1]){
                chars[l] = chars[r-1];
                l++;
                if(num>1){
                    String temp = Integer.toString(num);
                    for(char c: temp.toCharArray()){
                        chars[l++]=c;
                    }
                }
                num=1;
            }else{
                num++;
            }
        }
        return l;
    }
}