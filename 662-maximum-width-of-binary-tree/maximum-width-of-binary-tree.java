// Definition for a binary tree node (assumed to be defined elsewhere).
// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; }
// }

class Solution {

    public int widthOfBinaryTree(TreeNode root) {
        // Queue for BFS traversal of the tree nodes
        Queue<TreeNode> q = new LinkedList<>();
        // Queue to store the "position" of each node as if it's in a complete binary tree
        Queue<Integer> pos = new LinkedList<>();

        // Start with the root node at position 1
        q.add(root);
        pos.add(1);

        int max = 0;  // To track the maximum width

        // BFS traversal
        while (!q.isEmpty()) {
            int size = q.size(); // Number of nodes at the current level
            int l = 0, r = 0;     // Leftmost and rightmost positions at the current level

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();    // Current node
                int posi = pos.poll();       // Position of current node

                // Mark the leftmost and rightmost positions
                if (i == 0) l = posi;
                if (i == size - 1) r = posi;

                // For the left child, assign position = 2 * posi
                if (curr.left != null) {
                    q.add(curr.left);
                    pos.add(2 * posi);
                }

                // For the right child, assign position = 2 * posi + 1
                if (curr.right != null) {
                    q.add(curr.right);
                    pos.add(2 * posi + 1);
                }
            }

            // Update the maximum width
            max = Math.max(max, r - l + 1);
        }

        return max; // Return the maximum width found
    }
}
