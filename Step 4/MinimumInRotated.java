public class MinimumInRotated {

    public static int myapproach(int arr[], int n){
        int low = 0, high = n-1;
        while(low < high){
            int mid = low + (high - low)/2;
            if(arr[mid] < arr[high]){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        return arr[low];
    }
    
    public static void main(String args[]){
        int arr[] = {6, 1, 2, 3, 4, 5};
        int n = arr.length;
        System.out.println("Minimum element in rotated sorted array: " + myapproach(arr, n));
    }
}
