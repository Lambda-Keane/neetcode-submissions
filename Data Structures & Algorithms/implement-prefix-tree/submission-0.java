class PrefixTree {
    int value;
    PrefixTree[] children;
    boolean terminal;

    public PrefixTree() {
        this.value = 0;
        this.children = new PrefixTree[256];
        this.terminal = false;
    }

    public void insert(String word) {
        PrefixTree current = this;
        for (int i : word.toCharArray()) {
            if (current.children[i] == null) {
                current.children[i] = new PrefixTree();
                current.children[i].value = i;
            }
            current = current.children[i];
        }
        current.terminal = true;
    }

    public boolean search(String word) {
        PrefixTree current = this;
        for (int i : word.toCharArray()) {
            if (current.children[i] == null) return false;
            current = current.children[i];
        }
        return current.terminal;
    }

    public boolean startsWith(String prefix) {
        PrefixTree current = this;
        for (int i : prefix.toCharArray()) {
            if (current.children[i] == null) return false;
            current = current.children[i];
        }
        return true;
    }
}
