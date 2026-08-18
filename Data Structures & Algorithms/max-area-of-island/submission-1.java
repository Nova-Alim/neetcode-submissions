class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        if(grid==null || grid.length==0 || grid[0].length==0){return 0;}

        int maxArea = 0;

        for (int row=0; row<grid.length; row++){
            for( int col=0; col< grid[row].length; col++){
                    if(grid[row][col] ==1){
                        maxArea= Math.max(maxArea,  dfs(grid,row,col));
                    }
            }
        }

    return maxArea;
    }

    public int dfs(int[][] grid, int row, int col){
        if( row >= grid.length) return 0;
        if( row < 0) return 0;
        if( col <0) return 0;
        if( col >= grid[row].length) return 0;
        if(grid[row][col]==0) return 0;

        grid[row][col] =0;
        
        int area=1;

      
        area+= dfs(grid, row +1 , col);
        area+= dfs(grid, row -1 , col);
        area+= dfs(grid, row , col +1);
        area+= dfs(grid, row , col -1);

        return area;
    }
}
