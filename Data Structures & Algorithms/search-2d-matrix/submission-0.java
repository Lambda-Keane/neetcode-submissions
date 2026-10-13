class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int level = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        while (matrix[level][right] < target) {
            level++;
            if (level == matrix.length) return false;
        }
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (matrix[level][mid] == target) return true;
            else if (matrix[level][mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
