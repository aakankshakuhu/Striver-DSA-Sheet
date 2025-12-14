public class SearchInRotatedDuplicates {

    public static boolean myapproach(int arr[], int n, int k){
        int low = 0, high = n-1;
        while (low <= high){
            int mid = (low+high)/2;
            if(arr[mid] == k){
                return true;
            }
            if(arr[low] == arr[mid] && arr[mid] == arr[high]){
                low++;
                high--;
                continue;
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
        return false;
    }
    
    public static void main(String args[]){
        int arr[] = {3, 1, 2, 3, 3, 3, 3};
        int n = arr.length;
        int k = 3;
        System.out.println("Index of target in rotated sorted array: " + myapproach(arr, n, k));
    }
    
}
