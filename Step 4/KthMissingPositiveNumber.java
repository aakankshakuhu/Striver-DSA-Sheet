public class KthMissingPositiveNumber {

    public static int bruteforce(int arr[], int n, int k){
        for(int i = 0; i < n; i++){
            if(arr[i] <= k){
                k++;
            }
            else{
                return k;
            }
        }
        return -1;
    }

    public static int binarysearch(int arr[], int n, int k){
        if(k < arr[0]){
            return k;
        }
        int low = 0, high = n-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            int missing_numbers = arr[mid] - (mid+1);
            if(missing_numbers < k){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return k + high + 1;
    }
    

    public static void main(String args[]){
        int arr[] = {4, 7, 9, 10};
        int n = arr.length;
        int k = 6;
        System.out.println("Kth missing positive number from list: " + binarysearch(arr, n, k));
    }
}
