package islandmatrixtraversal;

import java.util.ArrayList;
import java.util.List;

public class BiggestIsland {
    public int maxAreaOfIsland(int [][] grid){
        int maxArea = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea, getIsland(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    private int getIsland(int [][] grid, int row, int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0){
            return 0;
        }
        grid[row][col] = 0;
        int area = 1;
        area += getIsland(grid, row-1, col);
        area += getIsland(grid, row+1, col);
        area += getIsland(grid, row, col-1);
        area += getIsland(grid, row, col+1);
        return area;

    }
    public static void main(String[] args) {
        BiggestIsland biggestIsland = new BiggestIsland();
        int [][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        int maxArea = biggestIsland.maxAreaOfIsland(grid);
        System.out.println("Max Area = " + maxArea);
    }


}
