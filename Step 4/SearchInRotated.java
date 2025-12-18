public class SearchInRotated {

    public static int myapproach(int arr[], int n, int k){
        int low = 0, high = n-1;
        while (low <= high){
            int mid = (low+high)/2;
            if(arr[mid] == k){
                return mid;
            }
            else if (arr[low] <= arr[mid]){
                if(k >= arr[low] && k < arr[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else{
                if(k > arr[mid] && k <= arr[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    
    public static void main(String args[]){
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        int n = arr.length;
        int k = 0;
        System.out.println("Index of target in rotated sorted array: " + myapproach(arr, n, k));
    }
}
