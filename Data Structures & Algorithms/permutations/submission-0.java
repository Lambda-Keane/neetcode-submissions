class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }
    public void backtrack(int[] nums, List<List<Integer>> result, List<Integer> currentPath, boolean[] used) {
        if (currentPath.size() == nums.length) {
            result.add(new ArrayList<>(currentPath));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            currentPath.add(nums[i]);

            backtrack(nums, result, currentPath, used);

            used[i] = false;
            currentPath.removeLast();
        }
    }
}
