package codility;

public class Solution {

    char[][] twoDimArray;

    public void init2DArray(int n, int m) {
        twoDimArray = new char[n][m];
    }

    public void addRow(int index, String row) {
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



        System.out.println(startRow);
        System.out.println(startColumn);


        return result;
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

        obj.solution(B);
        obj.display();
    }
}
