/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;
        int[] best = new int[1];
        maxHeight(root, best);
        return best[0];
    }
    public int maxHeight(TreeNode root, int[] best) {
        if (root == null) return 0;
        int l = maxHeight(root.left, best);
        int r = maxHeight(root.right, best);
        best[0] = Math.max(best[0], l+r);
        return 1 + Math.max(l, r);
    }
}
