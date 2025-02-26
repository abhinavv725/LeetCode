class Solution {
    int ans=0;
    char[] vow = new char[] {'a','e','i','o','u'};
    private void check(int j, int n,int k, StringBuilder sb){
        if(sb.length()==n){
            ans++;
            return;
        }
        for(int i=k;i<5;i++){
            sb.append(vow[i]);
            check(j+1, n,i, sb);
            sb.deleteCharAt(sb.length()-1);
        }

    }
    public int countVowelStrings(int n) {
        check(0, n, 0,new StringBuilder());
        return ans;
    }
}