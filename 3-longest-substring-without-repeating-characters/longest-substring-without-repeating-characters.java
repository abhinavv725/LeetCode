class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        // Key: Character, Value: The most recent index where the character appeared
        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If the character is already in the map, it's a potential duplicate
            if (map.containsKey(c)) {
                /* Move 'left' to the right of the last seen position of 'c'.
                   We use Math.max to ensure 'left' never moves backward if the 
                   duplicate 'c' is outside the current sliding window.
                */
                left = Math.max(left, map.get(c) + 1);
            }

            // Update/insert the character's last seen position
            map.put(c, right);

            // Calculate current window size (right - left + 1) and update max
            max = Math.max(max, right - left + 1);
        }

        /*
           Time Complexity: O(n)
           We iterate through the string of length 'n' once. Each character 
           is visited by the 'right' pointer exactly once.

           Space Complexity: O(min(m, n))
           We use a HashMap to store characters. The size is limited by either 
           the string length (n) or the size of the character set (m).
        */
        return max;
    }
}