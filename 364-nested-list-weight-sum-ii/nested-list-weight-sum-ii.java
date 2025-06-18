/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    private int maxDepth(List<NestedInteger> nestedList, int depth){
        int max = depth;
        for(NestedInteger ni : nestedList){
            if(!ni.isInteger())  
                max = Math.max(max, maxDepth(ni.getList(), depth+1));
            

        }
        return max;

    }

    private int check(List<NestedInteger> nestedList,int d, int maxD){
        int ans=0;

        for(NestedInteger ni : nestedList){
            if(ni.isInteger()){
                int w = maxD - (d)+1;
                ans+= w*ni.getInteger();
            }
            else{
                ans+=check(ni.getList(), d+1, maxD);
            }
        }
        return ans;
    }
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxD = maxDepth(nestedList, 1);
        return check(nestedList, 1,maxD);
    }
}