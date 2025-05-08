class Solution {
    private String invert(String s){
        StringBuilder temp = new StringBuilder();
        for(char c: s.toCharArray()){
            if(c=='1'){
                temp.append('0');
            }else{
                temp.append('1');
            }
        }
        return temp.reverse().toString();
    }
    public char findKthBit(int n, int k) {
        String s = "0";
        while(n-- >0){
            StringBuilder temp = new StringBuilder(s);
            temp.append("1");
            temp.append(invert(s));

            s = temp.toString();
        }
        return s.charAt(k-1);
    }
}