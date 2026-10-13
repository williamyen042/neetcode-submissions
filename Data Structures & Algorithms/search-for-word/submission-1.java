class Solution {
    int[][] direction = new int[][]{{0,1},{1,0},{0,-1}, {-1,0}};
    public boolean exist(char[][] board, String word) {
        boolean result = false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                result |= helper(board, word,visited, i,j,0);
            }
        }
        return result;
    }

    private boolean helper(char[][] board, String word, boolean[][] visited, int x, int y, int index) {
        if(index == word.length()) {
            return true;
        }

        //go each direction, if visited/ not in word, skip. if in word, mark as visited then recurse
        if(x < board.length && x >= 0 && y >= 0 && y < board[0].length && board[x][y] == word.charAt(index) && !visited[x][y]) {
            visited[x][y] = true;
            for(int[] dir : direction) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if(helper(board, word, visited, newX, newY, index + 1)) {
                    return true;
                }
            }
            visited[x][y] = false;
        }
        return false;
    }
}
