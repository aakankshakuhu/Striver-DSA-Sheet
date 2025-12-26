public class SearchInRowAndColWiseSortedArray {

    public static boolean myapproach(int arr[][], int n, int m, int target){
        int row = 0, col = m-1;
        while(row < n && col >= 0){
            if(arr[row][col] == target){
                return true;
            }
            else if(arr[row][col] < target){
                row++;
            }
            else{
                col--;
            }
        }
        return false;
    }
    
    public static void main(String args[]){
        int[][] arr = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        int n = arr.length;
        int m = arr[0].length;
        int target = 14;
        System.out.println("Is element present in row and column wise sorted array: " + myapproach(arr, n, m, target));
    }
}
