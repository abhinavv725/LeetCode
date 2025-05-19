class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> arr = new ArrayList<>();
        for(String time: timePoints){
            String[] a = time.split(":");
            int seconds = Integer.parseInt(a[0])*60+Integer.parseInt(a[1]);
            arr.add(seconds);
        }
        Collections.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i=1;i<arr.size();i++){
            int a = arr.get(i);
            int b = arr.get(i-1);
            int diff = Math.abs(a-b);
            min = Math.min(min, diff);
        }
        int last = arr.get(arr.size()-1);
        int first = arr.get(0);
        min=Math.min(min, 24*60 - last+first);
        return min;
    }
}