class Solution {
    public void solve(char[][] board) {
        Queue<int[]> letter = new LinkedList<>();

        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == 'O') {
                letter.offer(new int[] {0, col});
            }
        }

        for (int col = 0; col < board[0].length; col++) {
            if (board[board.length - 1][col] == 'O') {
                letter.offer(new int[] {board.length - 1, col});
            }
        }

        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == 'O') {
                letter.offer(new int[] {row, 0});
            }
        }

        for (int row = 0; row < board.length; row++) {
            if (board[row][board[0].length - 1] == 'O') {
                letter.offer(new int[] {row, board[0].length - 1});
            }
        }

         int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}

            };

        while (!letter.isEmpty()) {
            int[] position = letter.poll();

            int row = position[0];

            int col = position[1];

            board[row][col] = 'S';

            for (int[] direction : directions) {
                int newRow = row + direction[0];

                int newCol = col + direction[1];

                if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length
                    && board[newRow][newCol] == 'O') {
                    board[newRow][newCol] = 'S';
                    letter.offer(new int[] {newRow, newCol});
                }
            }
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }else if(board[row][col]=='S'){
                    board[row][col]='O';
                }
            }
        }
    }
}
