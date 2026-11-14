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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pV;
        int qV;
        if (p.val > q.val) {
            pV = q.val;
            qV = p.val;
        } else {
            pV = p.val;
            qV = q.val;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val >= pV && cur.val <= qV) {
                return cur;
            } else if (cur.val > qV) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return cur;
    }
}
