class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;

        for (String log : logs) {
            String[] parts = log.split(":");
            int functionId = Integer.parseInt(parts[0]);
            String type = parts[1];
            int time = Integer.parseInt(parts[2]);

            if (!stack.isEmpty()) {
                // Add time to the function on top of the stack
                result[stack.peek()] += time - prevTime;
            }

            if (type.equals("start")) {
                stack.push(functionId);
                prevTime = time;
            } else {
                // End of current function, add 1 extra unit for inclusive end time
                result[stack.pop()] += 1;
                prevTime = time + 1;
            }
        }

        return result;
    }
}
