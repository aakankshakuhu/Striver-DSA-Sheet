import java.util.HashMap;

public class CountSubarraySumEqualsK {
    
    public static int bruteforce(int arr[], int n, int given_sum) {
        int cnt = 0;
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
                cnt += preSum.get(rem);
            }

            preSum.put(sum, preSum.getOrDefault(sum,0) + 1);
        }
        return cnt;
    }

    public static void main(String args[]){
        int arr[] = {9, -3, 3, -1, 6, -5};
        int n = arr.length;
        int k = 0;
        System.out.println("No. of subarrays with sum k: " + hashmapapproach(arr, n, k));
    }
}
