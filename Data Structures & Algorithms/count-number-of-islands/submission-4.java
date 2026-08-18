class Solution {
    public int numIslands(char[][] grid) {

        if( grid==null || grid.length==0 ){ return 0; }
        
        int islands = 0;


        for(int row =0; row <grid.length; row++){
            for (int col=0; col<grid[row].length; col++){
                if(grid[row][col] == '1'){
                    dfs(grid,row,col);
                    islands++;
            }
        }


    }


    return islands;
}

private void dfs(char[][] grid, int row, int col){
    if(row <0 || row>=grid.length || col <0|| col>=grid[row].length || grid[row][col]=='0' ){
        return;
    }
    grid[row][col] = '0';

    dfs(grid,row, col+1);
    dfs(grid,row, col-1);
    dfs(grid,row+1, col);
    dfs(grid,row-1, col);

    }
}
