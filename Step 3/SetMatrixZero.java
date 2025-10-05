import java.util.ArrayList;
import java.util.Arrays;
public class SetMatrixZero {

    public static ArrayList<ArrayList<Integer>> bruteforce(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix.get(i).get(j) == 0) {
                    markRow(matrix, i, m);
                    markCol(matrix, j, n);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix.get(i).get(j) == -1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }
        return matrix;
    }

    private static void markRow(ArrayList<ArrayList<Integer>> matrix, int i, int m) {
        for(int j = 0; j < m; j++) {
            if(matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j, -1);
            }
        }
    }

    private static void markCol(ArrayList<ArrayList<Integer>> matrix, int j, int n) {
        for(int i = 0; i < n; i++) {
            if(matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j, -1);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> betterapproach(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int[] row = new int[n];
        int[] col = new int[m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix.get(i).get(j) == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(row[i] == 1 || col[j] == 1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }
        return matrix;
    }

    public static ArrayList<ArrayList<Integer>> optimalapproach(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int col0 = 1;
        
        //traverse the matrix and mark 1st row and 1st column
        for(int i = 0; i< n; i++){
            for(int j = 0; j < m; j++) {
                if(matrix.get(i).get(j) == 0) {
                    
                    //mark i-th row
                    matrix.get(i).set(0, 0);

                    //mark j-th column
                    if (j != 0)
                        matrix.get(0).set(j, 0);
                    else
                        col0 = 0;
                }
            }
        }

        //mark inner matrix
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(matrix.get(i).get(j) != 0) {
                    //check corresponding col and row
                    if(matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0)
                        matrix.get(i).set(j, 0);
                }
            }
        }

        //mark the first row and first column
        if(matrix.get(0).get(0) == 0) {
            for(int j = 0; j < m; j++) {
                matrix.get(0).set(j, 0);
            }
        }
        if(col0 == 0) {
            for(int i = 0; i < n; i++){
                matrix.get(i).set(0, 0);
            }
        }
        return matrix;
    }

    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> matrix =  new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(0, 1, 2, 0)));
        matrix.add(new ArrayList<>(Arrays.asList(3, 4, 5, 2)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 3, 1, 5)));

        int n = matrix.size();
        int m = matrix.get(0).size();

        ArrayList<ArrayList<Integer>> ans =  optimalapproach(matrix, n, m);

        for(ArrayList<Integer> row: ans) {
            for(Integer ele: row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
