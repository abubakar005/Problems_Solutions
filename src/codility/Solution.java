package codility;

public class Solution {

    char[][] twoDimArray;

    public void init2DArray(int n, int m) {
        twoDimArray = new char[n][m];
    }

    public void addRow(int index, String row) {

        char[] arr = row.toCharArray();

        /*for(int i=0; i<arr.length; i++) {

            if(arr[i] == '^' && index != 0) {
                for(int f=index; f>0; f--) {
                    if(arr[i] == '.')
                        a
                }
            }

            else if(arr[i] == '<' && i != 0)
                markObstacles(grid, row, col-1); // check left
            else if(arr[i] == '>' && i != arr.length-1)
                markObstacles(grid, row, col+1); // check right
            else if(arr[i] == 'v' && index != twoDimArray.length-1)
                markObstacles(grid, row+1, col);
        }*/

        twoDimArray[index] = row.toCharArray();
    }

    public boolean solution(String[] B) {

        boolean result = true;
        int n = B.length;
        int m = B[0].toCharArray().length;
        init2DArray(n, m);
        int startRow = -1;
        int startColumn = -1;

        for(int i=0; i<n; i++) {
            addRow(i, B[i]);

            if(B[i].contains("A")) {
                startRow = i;
                startColumn = B[i].indexOf('A');
            }
        }


        if(startRow == -1)  // if no A
            return false;

        boolean[][] visited = new boolean[n][m];

        for(int i=0; i< n; i++) { // initialize not visited (false)
            for (int j = 0; j < m; j++)
                visited[i][j] = false;
        }

     //   new Solution().display();
     //   System.out.println("=======================");

       /* for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {

                if(!visited[i][j]) {
                    markObstacles2(twoDimArray, i, j);
                    visited[i][j] = true;
                }

            }
        }*/

        boolean exist = true;//markObstacles(twoDimArray, 0, 0);

        if(exist)
            return false;

        dfs(twoDimArray, visited, startRow, startColumn);
        result = visited[n-1][m-1];
        return result;
    }

    private static boolean markObstacles(char[][] grid, int row, int col) {
        // escape condition
        if(row<0 || col<0 || row>=grid.length || col>= grid[0].length || grid[row][col] == 'X') {
            return true;
        }
        if(grid[row][col] == 'A')
            return false;
        //grid[row][col] = 'X';
        boolean isAExist = false;

        if(grid[row][col] == '^')
            isAExist = markObstacles(grid, row-1, col); // check up
        else if(grid[row][col] == '<')
            isAExist = markObstacles(grid, row, col-1); // check left
        else if(grid[row][col] == '>')
            isAExist = markObstacles(grid, row, col+1); // check right
        else if(grid[row][col] == 'v')
            isAExist = markObstacles(grid, row+1, col); // check down
        return isAExist;
    }

    private static void markObstacles2(char[][] grid, int row, int col) {

        if(row<0 || col<0 || row>=grid.length || col>= grid[0].length || grid[row][col] == 'X') {
            return;
        } else
            grid[row][col] = 'Y';

        if(grid[row][col] == '^')
            markObstacles(grid, row-1, col); // check up
        else if(grid[row][col] == '<')
            markObstacles(grid, row, col-1); // check left
        else if(grid[row][col] == '>')
            markObstacles(grid, row, col+1); // check right
        else if(grid[row][col] == 'v')
            markObstacles(grid, row+1, col); // check down
    }

    private static void dfs(char[][] grid, boolean[][] visited, int row, int col) {
        // escape condition
        if(row<0 || col<0 || row>=grid.length || col>= grid[0].length || visited[row][col] || grid[row][col]=='X' || grid[row][col]=='^' || grid[row][col]=='<'
                || grid[row][col]=='>' || grid[row][col]=='v') {
            return;
        }
        visited[row][col] = true;
        dfs(grid, visited, row-1, col); // check up
        dfs(grid, visited, row, col-1); // check left
        dfs(grid, visited, row, col+1); // check right
        dfs(grid, visited, row+1, col); // check down

    }


    public void display() {

        for(int i=0; i<twoDimArray.length; i++) {

            for(int j=0; j<twoDimArray[i].length; j++)
                System.out.print(twoDimArray[i][j] + " ");

            System.out.println();
        }
    }

    public static void main(String[] ags) {

        Solution obj = new Solution();
        String[] B = {"X.....>", "..v..X.", "A......"};
        String[] B1 = {"...Xv", "AX..^", ".XX.."};

        System.out.println(obj.solution(B));
        //obj.solution(B1);
        obj.display();
    }
}
