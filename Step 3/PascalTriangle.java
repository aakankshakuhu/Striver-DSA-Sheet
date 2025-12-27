public class PascalTriangle {

    //when we've been given the row and column number
    public static long variation1(int row, int col) {
        int n = row - 1;
        int r = col - 1;
        long res = 1;
        for(int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i+1);
        }
        return res;
    }

    //when we've been given the row number
    public static void variation2brute(int row) {
        int n = row-1;
        System.out.print("1 ");
        for(int r = 1; r < n; r++) { //nth row has n elements {}
            long res = 1;
            for(int i = 0; i < r; i++) {
                res = res * (n-i);
                res = res / (i+1);
            }
            System.out.print(res + " ");
        }
        System.out.println("1");
    }

    public static void variation2optimal(int row) {
        int n = row-1;
        long ans = 1;
        System.out.print(ans+ " ");
        for(int i = 1; i < n; i++) {
            ans = ans * (row - i);
            ans = ans/i;
            System.out.print(ans + " ");
        }
        System.out.println("1");
    }
    
    //print Pascal's Triangle uptil given row
    public static void variation3brute(int row) {
        System.out.println("1");
        for(int j = 2; j <= row; j++) {
            int n = j-1;
            System.out.print("1 ");
            for(int r = 1; r < n; r++) { //nth row has n elements {}
                long res = 1;
                for(int i = 0; i < r; i++) {
                    res = res * (n-i);
                    res = res / (i+1);
                }
                System.out.print(res + " ");
            }
            System.out.println("1");
            }
            System.out.println();
    }

    public static void variation3optimal(int row) {
        System.out.println("1");
        for(int j = 2; j <= row; j++) {
            int n = j-1;
            long ans = 1;
            System.out.print(ans+ " ");
            for(int i = 1; i < n; i++) {
                ans = ans * (j - i);
                ans = ans/i;
                System.out.print(ans + " ");
            }
            System.out.println("1");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int row = 7, col = 4;
        // System.out.println("Element: " + variation1(row, col));
        // variation2brute(5);
        // variation2optimal(6);
        variation3brute(6);
        variation3optimal(6);
    }
}