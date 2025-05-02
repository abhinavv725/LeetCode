class Solution {
    private void reverse(char[] s, int i, int j){
        while(i<=j){
            char temp = s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;j--;
        }
    }
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);
        int i=0,  j=0;
        while(i<s.length && j<s.length){
            while(j<s.length &&  s[j]!=' '){
                j++;
            }
            reverse(s, i, j-1);
            i=j+1;
            j=i;

        }
    }
}