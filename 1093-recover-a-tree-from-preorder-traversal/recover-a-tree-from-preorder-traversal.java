class Solution {
    public TreeNode recoverFromPreorder(String s) {
        Stack<TreeNode> st = new Stack<>();
        int ind = 0;

        // Traverse the entire input string
        while (ind < s.length()) {
            int depth = 0;

            // Count the number of dashes to determine the depth of the node
            while (ind < s.length() && s.charAt(ind) == '-') {
                depth++;
                ind++;
            }

            // Read the numeric value of the node
            int val = 0;
            while (ind < s.length() && Character.isDigit(s.charAt(ind))) {
                val = val * 10 + (s.charAt(ind) - '0');
                ind++;
            }

            // Create a new TreeNode with the parsed value
            TreeNode node = new TreeNode(val);

            // Ensure the stack's size matches the current node's depth
            while (st.size() > depth) {
                st.pop();
            }

            // If the parent node exists, attach the current node to it
            if (!st.isEmpty()) {
                if (st.peek().left == null) {
                    st.peek().left = node;
                } else {
                    st.peek().right = node;
                }
            }

            // Push the current node to the stack
            st.push(node);
        }

        // The root of the tree will be at the bottom of the stack
        while (st.size() > 1) {
            st.pop();
        }

        return st.peek();
    }
}
