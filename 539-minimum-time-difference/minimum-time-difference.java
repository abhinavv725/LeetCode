class Solution {
    private int min(String s){
        String[] parts = s.split(":");

        return Integer.parseInt(parts[0])*60 + Integer.parseInt(parts[1]);
    }
    public int findMinDifference(List<String> timePoints) {
        List<Integer> arr = new ArrayList<>();
        for(String s: timePoints){
            arr.add(min(s));
        }
        Collections.sort(arr);
        int mini = 1440+ arr.get(0)-arr.get(arr.size()-1);

        for(int i=1;i<arr.size();i++){
            mini = Math.min(mini, Math.abs(arr.get(i)-arr.get(i-1)));
        }
        return mini;
    }
}