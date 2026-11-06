class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        backtracking(0, new boolean[n][n], new ArrayList<>(), result);
        return result;
    }
    public void backtracking(int x,
                            boolean[][] board, 
                            List<boolean[]> current, 
                            List<List<String>> result) {
        if (x >= board.length) {
            List<String> list = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (boolean[] arr : current) {
                for (boolean a : arr) {
                    if (a) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                list.add(sb.toString());
                sb.setLength(0);
            }
            result.add(list); 
            return;
        }
        for (int y = 0; y < board.length; y++) {
            if (conflict(x, y, board)) {
                continue;
            }
            board[x][y] = true;
            current.add(board[x]);

            backtracking(x + 1 , board, current, result);

            board[x][y] = false;
            current.removeLast();
        }
    }
    public boolean conflict(int x, int y, boolean[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][y]) return true;
        }
        int tX = x, tY = y;
        while (tX >= 0 && tY >= 0) {
            if (board[tX][tY]) return true;
            tX--;
            tY--;
        }
        tX = x;
        tY = y;
        while (tX < board.length && tY < board.length) {
            if (board[tX][tY]) return true;
            tX++;
            tY++;
        }
        tX = x;
        tY = y;
        while (tX < board.length && tY >= 0) {
            if (board[tX][tY]) return true;
            tX++;
            tY--;
        }
        tX = x;
        tY = y;
        while (tX >= 0 && tY < board.length) {
            if (board[tX][tY]) return true;
            tX--;
            tY++;
        }
        return false;
    }
}
