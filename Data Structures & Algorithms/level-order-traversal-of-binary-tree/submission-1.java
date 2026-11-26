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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return List.of();
        List<List<Integer>> lists = new ArrayList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        map.put(root, 0);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            int level = map.get(tmp);

            if (lists.size() == level) {
                lists.add(new ArrayList<>());
            } 
            lists.get(level).add(tmp.val);

            if (tmp.left != null) {
                queue.offer(tmp.left);
                map.put(tmp.left, level+1);
            }
            if (tmp.right != null) {
                queue.offer(tmp.right);
                map.put(tmp.right, level+1);
            }
        }
        return lists;
    }
}
