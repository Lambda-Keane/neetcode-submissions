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
        return findWord(0, word,this);
    }

    public boolean findWord(int startAt, String word, WordDictionary current) {
        if (startAt == word.length()) {
            return current.terminal;
        }
        if (word.charAt(startAt) == '.') {
            for (int i = 0; i < children.length; i++) {
                if (current.children[i] != null) {
                    if (findWord(startAt + 1, word, current.children[i])) {
                        return true;
                    }
                }
            }
        } else {
            int index = word.charAt(startAt) - 'a';
            if (current.children[index] != null) {
                return findWord(startAt + 1, word, current.children[index]);
            }
        }
        return false;
    }
}
