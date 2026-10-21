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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return height(root) != -1;
    }
    public int height(TreeNode node) {
        if (node == null) return 0;
        TreeNode left = node.left;
        TreeNode right = node.right;
        if (left == null && right == null) {
            return 1;
        }
        int hL = height(left);
        int hR = height(right);
        if (hL == -1 || hR == -1) return -1;
        int h = Math.abs(hL - hR);
        if (h > 1) return -1;
        return 1 + Math.max(hL, hR);
    }
}
