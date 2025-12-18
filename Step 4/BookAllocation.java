public class BookAllocation {

    public static int bruteforce(int arr[], int n, int m){
        if (m > n){
            return -1;
        }
        for(int i = maxElm(arr, n); i <= findSum(arr, n); i++){
            if(canWeAllocateBooks(arr, n, i) == m){
                return i;
            }
        }
        return maxElm(arr, n);
    }

    public static int binarysearch(int arr[], int n, int m){
        int low = maxElm(arr, n), high = findSum(arr, n);
        while(low <= high){
            int mid = low + (high-low)/2;
            if(canWeAllocateBooks(arr, n, mid) > m){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return low;
    }

    public static int canWeAllocateBooks(int arr[], int n, int i){
        int std = 1;
        int pages = 0;
        for(int j = 0; j < n; j++){
            if(pages + arr[j] <= i){
                pages += arr[j];
            }
            else{
                std++;
                pages = arr[j];
            }
        }
        return std;
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
        int arr[] = {12, 34, 67, 90};
        int n = arr.length;
        int m = 2;
        System.out.println("Minimum maximum number of pages allocated to a student: " + binarysearch(arr, n, m));
    }
    
}
