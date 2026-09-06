class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> oranges = new LinkedList<>();

        int freshFruit = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    freshFruit++;
                }

                if (grid[row][col] == 2) {
                    oranges.offer(new int[] {row, col});
                }
            }
        }

        int minutes = 0;
        while (!oranges.isEmpty()) {
            int size = oranges.size();

            for (int i = 0; i < size; i++) {
                int[] current = oranges.poll();

                int row = current[0];
                int col = current[1];

                if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                    grid[row - 1][col] = 2;
                    freshFruit--;
                    oranges.offer(new int[]{row - 1, col});
                }

                // DOWN
                if (row + 1 < grid.length && grid[row + 1][col] == 1) {
                    grid[row + 1][col] = 2;
                    freshFruit--;
                    oranges.offer(new int[]{row + 1, col});
                }

                // LEFT
                if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                    grid[row][col - 1] = 2;
                    freshFruit--;
                    oranges.offer(new int[]{row, col - 1});
                }

                // RIGHT
                if (col + 1 < grid[row].length && grid[row][col + 1] == 1) {
                    grid[row][col + 1] = 2;
                    freshFruit--;
                    oranges.offer(new int[]{row, col + 1});
                }
            }

            minutes++;
        }

        if(freshFruit>0){
        return -1;
        }

        return minutes==0 ? 0 : minutes-1;
    }
}
