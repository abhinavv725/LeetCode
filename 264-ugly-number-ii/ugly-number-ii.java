class Solution {
    public int nthUglyNumber(int n) {
        TreeSet<Long> num = new TreeSet<>();
        num.add(1L);
        long curr=0;
        while(n-- > 0){
            curr = num.pollFirst();
            num.add(curr*2);
            num.add(curr*3);
            num.add(curr*5);
        }
        return (int) curr;
    }
}