class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> arr = new ArrayList<>();

        // Convert all time strings to minutes past midnight
        for (String time : timePoints) {
            String[] a = time.split(":"); // Split hours and minutes
            int minutes = Integer.parseInt(a[0]) * 60 + Integer.parseInt(a[1]); // Convert to total minutes
            arr.add(minutes);
        }

        // Sort all time points (in minutes)
        Collections.sort(arr);

        int min = Integer.MAX_VALUE;

        // Calculate the minimum difference between consecutive times
        for (int i = 1; i < arr.size(); i++) {
            int a = arr.get(i);
            int b = arr.get(i - 1);
            int diff = Math.abs(a - b); // Difference between adjacent times
            min = Math.min(min, diff);
        }

        // Check the circular difference between the last and first time points (across midnight)
        int last = arr.get(arr.size() - 1);
        int first = arr.get(0);
        min = Math.min(min, 24 * 60 - last + first); // Handle wrap-around case

        return min;
    }
}
