class Solution {
    public String check(String pattern) {
        StringBuilder result = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();

        int n = pattern.length();
        for (int i = 0; i <= n; i++) {
            // Push i+1 because digits start from 1
            stack.push(i + 1);

            // If end of pattern or current char is 'I', flush the stack
            if (i == n || pattern.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }

        return result.toString();
    }
    public String smallestNumber(String pattern) {
        return check(pattern);
    }
}