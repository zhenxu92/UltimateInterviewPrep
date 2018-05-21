/**
 * @author: Zhen Xu
 * LeetCode Problem: Island Perimeter
 * https://leetcode.com/problems/grid-perimeter/
 * Ver 1.0
 *
 * This program use two dimensional array to decribe a grid of lands.
 * Every element of the grid is a square and the total grid is rectangular.
 * The number 1 in the 2D array {@code grid} means a piece of land, the number 0 means
 * water. There is no "lake", meaning there should not be any water inside
 * a land. There is also only one land in a grid. Calculate the perimeter of this land.
 * 
 * <p>Solution: scan through the each "square" in the grid, the index pair of it
 * should be (i, j). Check if (i-1, j), (i, j-1), (i+1, j), (i, j+1) is null or one, 
 * if so, no perimeter addition, otherwise, perimeter add one.
*/
public class IslandPerimeter {
    public static void main (String args[]) {
        int[][] grid = new int[4][4];
        grid[0][1] = 1;
        grid[1][0] = 1;
        grid[1][1] = 1;
        grid[1][2] = 1;
        grid[2][1] = 1;
        grid[3][0] = 1;
        grid[3][1] = 1;
        // check if this grid is correct
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]);
            }
        }   
        System.out.println();
        int perimeter = ip(grid); 
        System.out.println(perimeter);       
    }
    
    public static int ip (int[][] grid) {
        System.out.println(grid.length);      // show the number of rows
        System.out.println(grid[0].length);   // show the number of columns
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    //top part
                    if(i-1 < 0) {
                        perimeter++;
                    } else if(grid[i-1][j] != 1) {
                        perimeter++;
                    }
                    
                    //bottom part
                    if(i+1 >= grid.length) {
                        perimeter++;
                    } else if(grid[i+1][j] != 1) {
                        perimeter++;
                    }
                    
                    // right part
                    if(j+1 >= grid[0].length) {
                        perimeter++;
                    } else if(grid[i][j+1] != 1) {
                        perimeter++;
                    }
                    
                    // left part
                    if(j-1 < 0) {
                        perimeter++;
                    } else if(grid[i][j-1] != 1) {
                        perimeter++;
                    }
                }
            }
        }

        return perimeter;
    }
}