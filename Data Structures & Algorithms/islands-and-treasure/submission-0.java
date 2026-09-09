class Solution {
    public void islandsAndTreasure(int[][] grid) {
        
        int INF=2147483647;


        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){

                if(grid[i][j]== 0){
                    queue.offer(new int[]{i,j});
                }

            }
        }

        while(!queue.isEmpty()){

            int[] position= queue.poll();
            int row= position[0];
            int col= position[1];


            int[][] directions= {
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}
            };

            for(int[] direction: directions){
                int newRow= direction[0] + row;
                int newCol= direction[1] + col;


                if(newRow < grid.length && newRow >= 0 && newCol < grid[newRow].length && newCol>= 0){
                    if(grid[newRow][newCol]== INF){
                        grid[newRow][newCol]= grid[row][col]+1;
                        queue.offer(new int[]{newRow,newCol});
                    }
                }

            }



        }



    }
}
