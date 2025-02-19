class Solution {
    private void check(char prev, List<String> ans, StringBuilder curr, int n){
        if(curr.length()==n){
            ans.add(curr.toString());
            return;
        }
        char[] available = new char[] {'a','b','c'};
        for(char s: available){
            if(s!=prev){
                curr.append(s);
                check(s, ans, curr, n);
                curr.deleteCharAt(curr.length()-1);
            }
            
        }

    }
    public String getHappyString(int n, int k) {
        char[] available = new char[] {'a','b','c'};
        List<String> ans = new ArrayList<>();
        check('d', ans, new StringBuilder(),n );
        // for(String val: ans){
        //     System.out.print(val +" ");
        // }
        if(k-1<ans.size()){
            return ans.get(k-1);
        }
        return "";
    }
}