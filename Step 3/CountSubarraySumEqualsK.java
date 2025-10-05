import java.util.HashMap;

public class CountSubarraySumEqualsK {
    
    public static int bruteforce(int arr[], int n, int given_sum) {
        int len = 0, cnt = 0;
        for(int i = 0; i < n; i++){
            long sum = 0;
            for(int j = i; j < n; j++) {
                sum += arr[j];
                if(sum == given_sum) {
                    cnt++;
                }
            }    
        }
        return cnt;
    }

    public static int hashmapapproach(int arr[], int n, int k ){

        HashMap<Long, Integer> preSum = new HashMap<>();
        long sum = 0;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            if(sum == k){
                cnt++;
            }
            long rem = sum - k;
            
            if(preSum.containsKey(rem)){
                int len = i - preSum.get(rem);
                cnt++;
            }

            if(!preSum.containsKey(sum)) { 
                preSum.put(sum, i);
            }
        }
        return cnt;
    }

    public static void main(String args[]){
        int arr[] = {3, 1, 2, 4};
        int n = arr.length;
        int k = 6;
        System.out.println("No. of subarrays with sum k: " + bruteforce(arr, n, k));
    }
}
