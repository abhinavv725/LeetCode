class Solution {
    private boolean check(String s, Set<String> set){
        return set.contains(s);
    }

    private boolean perm(int i, StringBuilder sb, Set<String> set, int n){
        if(i>=n){
            return !check(sb.toString(), set);
        }
        sb.setCharAt(i, '0');
        if(perm(i+1, sb, set, n)){
            return true;
        }
        sb.setCharAt(i, '1');
        if(perm(i+1, sb, set, n))
            return true;
        return false;
    }

    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();
        for(String s: nums) set.add(s);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<nums.length;i++)  sb.append('0');

        perm(0, sb, set, nums.length);
        return sb.toString();

    }
}