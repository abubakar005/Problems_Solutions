package graph;

public class NoOfIslands {

    public int calculateIslands(char[][] grid) {

        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    visitAdjacentNodes(i, j, visited, grid);
                    count++;
                }
            }
        }

        return count;
    }

    private void visitAdjacentNodes(int i, int j, boolean[][] visited, char[][] grid) {

        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length
            || visited[i][j] || grid[i][j] == 0)
            return;

        visited[i][j] = true;

        visitAdjacentNodes(i-1, j, visited, grid);
        visitAdjacentNodes(i+1, j, visited, grid);
        visitAdjacentNodes(i, j-1, visited, grid);
        visitAdjacentNodes(i, j+1, visited, grid);
    }


    public static void main(String[] ags) {

        NoOfIslands noOfIslands = new NoOfIslands();

        /**  Graphical representation

         1  1   0   0
         1  0   0   0
         0  0   1   0
         0  0   0   1

         answer should be 3
         */

        char[][] grid = {{1,1,0,0}, {0,1,0,1}, {0,0,1,0}, {0,0,0,1}};

        int count = noOfIslands.calculateIslands(grid);
        System.out.println(count);
    }
}
