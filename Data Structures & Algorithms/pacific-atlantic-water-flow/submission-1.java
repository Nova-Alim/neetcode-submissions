class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;

        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        for (int col = 0; col < heights[0].length; col++) {
            pacific[0][col] = true;
            pacificQueue.offer(new int[] {0, col});
        }

        for (int row = 0; row < heights.length; row++) {
            pacific[row][0] = true;
            pacificQueue.offer(new int[] {row, 0});
        }

        while (!pacificQueue.isEmpty()) {
            int[] position = pacificQueue.poll();

            int row = position[0];

            int col = position[1];

            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            for (int[] direction : directions) {
                int newRow = row + direction[0];

                int newCol = col + direction[1];

                if (newRow < heights.length && newRow >= 0 && newCol >= 0
                    && newCol < heights[newRow].length && pacific[newRow][newCol] == false
                    && heights[newRow][newCol] >= heights[row][col]) {
                    pacific[newRow][newCol] = true;
                    pacificQueue.offer(new int[] {newRow, newCol});
                }
            }
        }

        for (int col = 0; col < heights[0].length; col++) {
            atlantic[heights.length-1][col] = true;
            atlanticQueue.offer(new int[] {heights.length-1, col});
        }

        for (int row = 0; row < heights.length; row++) {
            atlantic[row][heights[0].length-1] = true;
            atlanticQueue.offer(new int[] {row, heights[0].length-1});
        }


          while (!atlanticQueue.isEmpty()) {
            int[] position = atlanticQueue.poll();

            int row = position[0];

            int col = position[1];

            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            for (int[] direction : directions) {
                int newRow = row + direction[0];

                int newCol = col + direction[1];

                if (newRow < heights.length && newRow >= 0 && newCol >= 0
                    && newCol < heights[newRow].length && atlantic[newRow][newCol] == false
                    && heights[newRow][newCol] >= heights[row][col]) {
                    atlantic[newRow][newCol] = true;
                    atlanticQueue.offer(new int[] {newRow, newCol});
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();


        for(int row=0; row<heights.length;row++){
            for(int col=0; col<heights[row].length;col++){
                if(pacific[row][col] && atlantic[row][col]== true){
                    List<Integer> list = new ArrayList<>();
                    list.add(row);
                    list.add(col);
                    result.add(list);

                }
            }
        }

        return result;
        
    }
}
