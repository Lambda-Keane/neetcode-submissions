class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.isBlank()) return true;
        if (s2.isBlank()) return false;

        Map<Character, Integer> map = new HashMap<>();
        Set<Character> hSet = new HashSet<>();
        int[] set = new int[26];

        for (char c : s1.toCharArray()) {
            map.computeIfAbsent(c, k -> 0);
            map.merge(c, 1, Integer::sum);
            hSet.add(c);
            set[c - 'a']++;
        }

        int sl = 0;

        for (int fa = 0; fa < s2.length(); fa++) {
            char sC = s2.charAt(sl);
            char fC = s2.charAt(fa);
            if (fa - sl >= s1.length()) {
                if (hSet.contains(sC)) {
                    if (set[sC - 'a'] >= 0) {
                        map.computeIfAbsent(sC, k -> 0);
                        map.merge(sC, 1, Integer::sum);
                    }
                    set[sC - 'a']++;
                }
                sl++;
            }
            if (hSet.contains(fC)) {
                if (map.containsKey(fC)) {
                    int tmp = map.merge(fC, -1, Integer::sum);
                    if (tmp == 0) map.remove(fC);
                }
                set[fC - 'a']--;
            }
            if (map.isEmpty()) return true;
        }
        return map.isEmpty();
    }
}
