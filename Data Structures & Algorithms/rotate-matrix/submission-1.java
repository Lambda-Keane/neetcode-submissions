class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int t = 0;
        while (t < n/2) {
            for (int i = 0; i < n; i++) {
                int temp = matrix[t][i];
                matrix[t][i] = matrix[n-1-t][i];
                matrix[n-1-t][i] = temp;
            }
            t++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
