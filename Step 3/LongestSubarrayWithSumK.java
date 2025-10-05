import java.util.HashMap;
public class LongestSubarrayWithSumK {
    
    public static int bruteforce(int arr[], int n, int given_sum){
        int len = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                long sum = 0;
                for(int k = i; k <= j; k++){
                    sum += arr[k];
                }
                if(sum == given_sum){
                   len = Math.max(len, j-i+1);
                }
            }
        }
        return len;
    }

    public static int bruteforce2(int arr[], int n, int given_sum) {
        int len = 0;
        for(int i = 0; i < n; i++){
            long sum = 0;
            for(int j = i; j < n; j++) {
                sum += arr[j];
                if(sum == given_sum) {
                    len = Math.max(len, j-i+1);
            }
            }
            
        }
        return len;
    }

    public static int hashmapapproach(int arr[], int n, int k ){

        HashMap<Long, Integer> preSum = new HashMap<>();
        long sum = 0;
        int max_len = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            if(sum == k){
                max_len = Math.max(max_len, i+1);
            }
            long rem = sum - k;
            
            if(preSum.containsKey(rem)){
                int len = i - preSum.get(rem);
                max_len = Math.max(max_len, len);
            }

            if(!preSum.containsKey(sum)) { 
                preSum.put(sum, i);
            }
        }
        return max_len;
    }


    public static int twopointersapproach(int arr[], int n, int k) {
        int left = 0, right = 0;
        int maxlen = 0;
        int sum = arr[0];
         
        while(right < n){
            while(left <= right && sum > k) {
                sum = sum - arr[left];
                left++;
            }
            if(sum == k){
                maxlen = Math.max(maxlen, right-left+1);
            }
            right++;
            if(right < n){
                sum = sum + arr[right];
            }
        }
        return maxlen;
    }
    public static void main(String args[]){
        int arr[] = {2,3,5,1,9};
        int n = arr.length;
        int k = 10;
        System.out.println("Length of longest subarray: " + twopointersapproach(arr, n, k));
    }
}
