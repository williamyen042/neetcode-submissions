class Solution {
    public boolean isValidSudoku(char[][] board) {
        //27 hashmaps - 9 for rows, 9 for col, 9 per square
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] squares = new HashSet[9];

        for(int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            squares[i] = new HashSet<>();
        }



        

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if(c == '.') {
                    continue;
                }
                int index = (i / 3) * 3 + (j / 3);
                if(rows[i].contains(c) || cols[j].contains(c) || squares[index].contains(c)) {
                    return false;
                } else {
                    rows[i].add(c);
                    cols[j].add(c);
                    squares[index].add(c);
                }

            }
            
        }
        return true;
    }
}
