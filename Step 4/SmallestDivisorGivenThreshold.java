public class SmallestDivisorGivenThreshold {

    public static int myapproach(int arr[], int n, int k){
        int low = 1, high = maxElm(arr, n), ans = Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(findSum(arr, n, mid) <= k){
                ans = Math.min(ans, mid);
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    public static int findSum(int arr[], int n, int mid){
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += (arr[i] + mid - 1)/mid;
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
        int arr[] = {1,2,3,4,5};
        int n = arr.length;
        int k = 8;
        System.out.println("Smallest divisor for the given threshold: " + myapproach(arr, n, k));
    }
}
