class Solution {
    private boolean check(String word) {
        return isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1));
    }

    private boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] arr = new int[words.length];
        arr[0] = check(words[0]) ? 1: 0; 
        for(int i=1;i<words.length;i++){
            arr[i] =check(words[i]) ? 1: 0;  
            arr[i] += arr[i-1];
        }
        int n = queries.length;
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            int l=queries[i][0], r = queries[i][1];
            ans[i] = l==0 ? arr[r]: arr[r]-arr[l-1];
        }
        return ans;
    }
}