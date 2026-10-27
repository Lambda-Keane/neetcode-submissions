class Solution {
    public int characterReplacement(String s, int k) {
        if (s.isBlank()) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int maxFreq = 0;
        int maxLen = 0;
        for (int r = 0; r < s.length(); r++) {
            map.merge(s.charAt(r), 1, Integer::sum);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(r)));

            if ((r - l + 1) - maxFreq > k) {
                map.merge(s.charAt(l), -1, Integer::sum);
                l++;
            }

            maxLen = Math.max(r - l + 1, maxLen);
        }
        return maxLen;
    }
}
