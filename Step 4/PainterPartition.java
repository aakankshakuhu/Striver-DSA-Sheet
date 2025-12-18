public class PainterPartition {

    public static int bruteforce(int arr[], int n, int k){
        for(int i = maxElm(arr, n); i <= findSum(arr, n); i++){
            if(noOfSubarrays(arr, n, i) == k){
                return i;
            }
        }
        return -1;
    }

    public static int binarysearch(int arr[], int n, int k){
        int low = maxElm(arr, n), high = findSum(arr, n);
        while(low <= high){
            int mid = low + (high-low)/2;
            if(noOfSubarrays(arr, n, mid) <= k){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }

    public static int noOfSubarrays(int arr[], int n, int i){
        int subarray = 1;
        int sum = 0;
        for(int j = 0; j < n; j++){
            if(sum+arr[j] <= i){
                sum += arr[j];
            }
            else{
                subarray++;
                sum = arr[j];
            }
        }
        return subarray;
    }

    public static int findSum(int arr[], int n){
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
        }
        return sum;
    }

    public static int maxElm(int arr[], int n){
        int max = arr[0];
        for(int i = 1; i < n; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String args[]){
        int arr[] = {10, 20, 30, 40};
        int n = arr.length;
        int k = 2;
        System.out.println("Subarray with the minimum maximum sum: " + binarysearch(arr, n, k));
    }
}
