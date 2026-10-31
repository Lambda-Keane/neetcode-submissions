class Solution {
    public int[] countBits(int n) {
        int k = 0;
        int[] bin = new int[n+1];
        bin[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (k == i/2) {
                k = i;
                bin[k] = 1;
                continue;
            }
            bin[i] = bin[k] + bin[i-k];
            
        }
        return bin;
    }
}
