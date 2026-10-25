class WordDictionary {
    WordDictionary[] children;
    boolean terminal;

    public WordDictionary() {
        this.children = new  WordDictionary[26];
        this.terminal = false;
    }

    public void addWord(String word) {
        WordDictionary current = this;
        for (int i : word.toCharArray()) {
            i -= 'a';
            if (current.children[i] == null) {
                current.children[i] = new WordDictionary();
            }
            current = current.children[i];
        }
        current.terminal = true;
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        return findWord(0, chars,this);
    }

    public boolean findWord(int startAt, char[] chars, WordDictionary current) {
        if (chars[startAt] == '.') {
            for (int i = 0; i < children.length; i++) {
                if (current.children[i] != null) {
                    if (startAt == chars.length - 1) {
                        return current.children[i].terminal;
                    }
                    if (findWord(startAt + 1, chars, current.children[i])) {
                        return true;
                    }
                }
            }
        } else {
            if (startAt == chars.length - 1) {
                if (current.children[chars[startAt] - 'a'] == null) return false;
                return current.children[chars[startAt] - 'a'].terminal;
            }
            if (current.children[chars[startAt] - 'a'] != null) {
                return findWord(startAt + 1, chars, current.children[chars[startAt] - 'a']);
            }
        }
        return false;
    }
}
