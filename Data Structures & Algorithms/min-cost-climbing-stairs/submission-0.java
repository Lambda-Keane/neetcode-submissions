class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] c = new int[cost.length];
        for (int i = cost.length - 1; i >= 0; i--) {
            if (i + 1 >= cost.length || i + 2 >= cost.length) {
                c[i] = cost[i];
                continue;
            }
            c[i] = cost[i] + Math.min(c[i+1], c[i+2]);
        }
        return Math.min(c[0], c[1]);
    }
}
