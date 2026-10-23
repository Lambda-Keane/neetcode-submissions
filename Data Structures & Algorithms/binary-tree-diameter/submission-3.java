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
        Map<Integer, Integer> map = new HashMap<>();
        maxHeight(root, map);
        int max = map.values().stream()
        .mapToInt(Integer::intValue)
        .max()
        .orElse(0);
        return max;
    }
    public int maxHeight(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            map.put(root.val, 1);
            return 1;
        }
        int l = maxHeight(root.left, map);
        int r = maxHeight(root.right, map);
        map.put(root.val, l+r);
        return 1 + Math.max(l, r);
    }
}
