class Solution {
    private String invert(String s){
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='0') sb.append('1');
            else    sb.append('0');
        }
        return sb.reverse().toString();
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