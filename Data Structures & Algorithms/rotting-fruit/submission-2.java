class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;

        Queue<int[]> rotten = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int orange = grid[i][j];

                if (orange == 1) {
                    fresh++;
                }

                if (orange == 2) {
                    rotten.offer(new int[] {i, j});
                }
            }
        }

        int minutes = 0;

        while (!rotten.isEmpty() && fresh>0) {

        int size = rotten.size();

            while (size > 0) {

            int[] orange = rotten.poll();

            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            for (int[] direction : directions) {
                int newRow = direction[0] + orange[0];
                int newCol = direction[1] + orange[1];

                if (newRow >= 0 && newRow < grid.length && newCol >= 0
                    && newCol < grid[newRow].length && grid[newRow][newCol] == 1) {
                    fresh--;
                    grid[newRow][newCol] = 2;
                    rotten.offer(new int[] {newRow, newCol});
                }
            }


                size--;
            }

            minutes++;
        }

        return fresh ==0 ? minutes : -1;
    }
}
