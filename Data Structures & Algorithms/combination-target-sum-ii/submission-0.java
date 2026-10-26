class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, target, 0, new ArrayList<>(), result);
        return result;
    }
    public void backtrack(int[] nums, 
                        int target, 
                        int start,
                        List<Integer> current,
                        List<List<Integer>> result) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (start == nums.length) return;
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) continue;
            if (i > start && nums[i] == nums[i-1]) continue;
            
            current.add(nums[i]);

            backtrack(nums, target - nums[i], i+1, current, result);

            current.removeLast();
        }
    }
}
