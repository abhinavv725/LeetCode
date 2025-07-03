class Solution {
    private String add(String s){
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            arr[i] = (char) (((arr[i] - 'a' + 1) % 26) + 'a');
        }
        return s + new String(arr);
    }
    public char kthCharacter(int k) {
        String s = "a";
        while(s.length()<k){
            s = add(s);
        }
        return s.charAt(k-1);
    }
}