class Solution {
    public int maxArea(int[] heights) {
        if (heights.length == 0) return 0;
        int left = 0;
        int right = heights.length - 1;
        int max = 0;
        while (left <= right) {
            int w = right - left;
            int h = Math.min(heights[left], heights[right]);
            max = Math.max(max, w*h);
            if (heights[left] > heights[right]) right--;
            else left++;
        }
        return max;
    }
}
