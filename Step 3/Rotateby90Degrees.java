public class Rotateby90Degrees {

    public static void bruteforce(int arr[][], int n) {
        int rotated[][] = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                rotated[i][j] = arr[(n-1)-j][i];
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(rotated[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void optimalapproach(int arr[][], int n) {
        //transpose matrix
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        //reverse
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n/2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][n-1];
                arr[i][n-1] = temp;
            }
        }

        //print
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
    }
    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int n = arr.length;
        optimalapproach(arr, n);
    }
}
