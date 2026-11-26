class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        int[] s1Count = new int[26];
        int matches = 0;

        for (int i = 0; i < s1.length(); i++) {
            int c = s1.charAt(i);
            set.add(c);
            s1Count[c-'a']++;
        }

        int h = 0; //slow
        for (int i = 0; i < s2.length(); i++) {
            int c = s2.charAt(i);
            if (set.contains(c)) {
                if (s1Count[c-'a'] > 0) {
                    if (matches == 0) {
                        h = i;
                    }
                    matches++;
                    if (matches == s1.length()) return true;
                    s1Count[c-'a']--;
                } else {
                    for (int j = h; j < i; j++) {
                        if (s2.charAt(j) == c) {
                            h = j + 1;
                            break;
                        }
                        matches--;
                        s1Count[s2.charAt(j)-'a']++;
                    }
                }
            } else {
                matches = 0;
                for (int j = h; j < i; j++) {
                    s1Count[s2.charAt(j)-'a']++;
                }
            }
        }
        return matches == s1.length();
    }
}
