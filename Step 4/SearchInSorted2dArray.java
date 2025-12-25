public class SearchInSorted2dArray {

    public static boolean binarysearch(int arr[][], int n, int m, int target){
        int low = 0, high = (n*m)-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            int row_cord = mid/m;
            int col_cord = mid%m;
            if(arr[row_cord][col_cord] == target){
                return true;
            }
            else if(arr[row_cord][col_cord] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return false;
    }

    public static void main(String args[]){
        int arr[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int n = 3, m = 4;
        int target = 8;
        System.out.println("Is element present in a sorted 2D array: " + binarysearch(arr, n, m, target));
    }
    
}
