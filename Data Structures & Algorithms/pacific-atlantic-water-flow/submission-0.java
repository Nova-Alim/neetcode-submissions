class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        Queue<int[]> pacQueue = new LinkedList<>();
        Queue<int[]> atlQueue = new LinkedList<>();

        // Top row + left column = Pacific
        for (int col = 0; col < cols; col++) {
            pacific[0][col] = true;
            pacQueue.offer(new int[]{0, col});
        }

        for (int row = 0; row < rows; row++) {
            pacific[row][0] = true;
            pacQueue.offer(new int[]{row, 0});
        }

        // Bottom row + right column = Atlantic
        for (int col = 0; col < cols; col++) {
            atlantic[rows - 1][col] = true;
            atlQueue.offer(new int[]{rows - 1, col});
        }

        for (int row = 0; row < rows; row++) {
            atlantic[row][cols - 1] = true;
            atlQueue.offer(new int[]{row, cols - 1});
        }

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        // BFS from Pacific
        while (!pacQueue.isEmpty()) {

            int[] current = pacQueue.poll();
            int row = current[0];
            int col = current[1];

            for (int[] direction : directions) {

                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < cols &&
                    !pacific[newRow][newCol] &&
                    heights[newRow][newCol] >= heights[row][col]) {

                    pacific[newRow][newCol] = true;
                    pacQueue.offer(new int[]{newRow, newCol});
                }
            }
        }

        // BFS from Atlantic
        while (!atlQueue.isEmpty()) {

            int[] current = atlQueue.poll();
            int row = current[0];
            int col = current[1];

            for (int[] direction : directions) {

                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < cols &&
                    !atlantic[newRow][newCol] &&
                    heights[newRow][newCol] >= heights[row][col]) {

                    atlantic[newRow][newCol] = true;
                    atlQueue.offer(new int[]{newRow, newCol});
                }
            }
        }

        List<List<Integer>> answer = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (pacific[row][col] && atlantic[row][col]) {
                    answer.add(Arrays.asList(row, col));
                }
            }
        }

        return answer;
    }
}