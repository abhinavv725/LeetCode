
class Solution {
    private int index = 0;
    private TreeNode dfs(String s, int depth){
        int n=s.length(), num=0,d=0;
        int tempI= index;
        while(tempI<n && s.charAt(tempI)=='-'){
            tempI++;
            d++;
        }
        if(d!=depth){
            return null;
        }
        index=tempI;
        while(index<n && Character.isDigit(s.charAt(index))){
            
            num=num*10+s.charAt(index)-'0';
            index++;
        }
        TreeNode node =new TreeNode(num);
        node.left=dfs(s, depth+1);
        node.right=dfs(s, depth+1);
        return node;
    }
    public TreeNode recoverFromPreorder(String traversal) {
        return dfs(traversal,0);
    }
}