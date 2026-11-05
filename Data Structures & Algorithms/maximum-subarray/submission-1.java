class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int sum = nums[0];
        int i = 1;
        while (i < n) {
            if (nums[i] >= 0 || sum + nums[i] > 0) {
                if (sum < 0) sum = 0;
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(nums[i], Math.max(sum, max));
            i++;
        }
        return max;
    }
}
