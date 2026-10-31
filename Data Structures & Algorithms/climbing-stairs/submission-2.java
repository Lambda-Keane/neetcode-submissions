class Solution {
    public int climbStairs(int n) {
        if (n < 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] memo = new int[n];
        memo[0] = 1;
        memo[1] = 2;
        for (int i = 3; i <= n; i++) {
            memo[i-1] = memo[i-2] + memo[i-3];
        }
        return memo[n-1];
    }
}
