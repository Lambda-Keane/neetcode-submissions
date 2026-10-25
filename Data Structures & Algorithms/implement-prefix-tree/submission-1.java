class PrefixTree {
    PrefixTree[] children;
    boolean terminal;

    public PrefixTree() {
        this.children = new PrefixTree[26];
        this.terminal = false;
    }

    public void insert(String word) {
        PrefixTree current = this;
        for (int i : word.toCharArray()) {
            i -= 'a';
            if (current.children[i] == null) {
                current.children[i] = new PrefixTree();
            }
            current = current.children[i];
        }
        current.terminal = true;
    }

    public boolean search(String word) {
        PrefixTree current = this;
        for (int i : word.toCharArray()) {
            i -= 'a';
            if (current.children[i] == null) return false;
            current = current.children[i];
        }
        return current.terminal;
    }

    public boolean startsWith(String prefix) {
        PrefixTree current = this;
        for (int i : prefix.toCharArray()) {
            i -= 'a';
            if (current.children[i] == null) return false;
            current = current.children[i];
        }
        return true;
    }
}
