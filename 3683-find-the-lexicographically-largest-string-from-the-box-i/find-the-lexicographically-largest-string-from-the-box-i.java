class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends==1)
            return word;
        int len = word.length()-numFriends+1;
        String ans = "";
        for(int i=0;i<word.length();i++){
            int k = Math.min(word.length() - i, len);
            
            String temp = word.substring(i, i+k);
            if(temp.compareTo(ans)>0){
                ans = temp;
            }
            // ans = Math.max(ans, sb.toString());
        }
        return ans;
    }
}