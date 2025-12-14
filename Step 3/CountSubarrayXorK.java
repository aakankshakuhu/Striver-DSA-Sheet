import java.util.HashMap;

public class CountSubarrayXorK {

    public static int loopapproach(int arr[], int n, int k){
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            int xor = 0;
            for(int j = i; j < n; j++){
                xor = xor ^ arr[j];
                if(xor == k){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static int hashmapapproach(int arr[], int n, int k ){

        HashMap<Long, Integer> preSum = new HashMap<>();
        long xor = 0;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            xor ^= arr[i];
            if(xor == k){
                cnt++;
            }
            long rem = xor ^  k;
            
            if(preSum.containsKey(rem)){
                cnt += preSum.get(rem);
            }

            preSum.put(xor, preSum.getOrDefault(xor,0) + 1);
        }
        return cnt;
    }
    
    public static void main(String args[]){
        int arr[] = {4, 2, 2, 6, 4};
        int n = arr.length;
        int k = 6;
        System.out.println("Number of subarrays with XOR equal~~ to k: " + hashmapapproach(arr, n, k));
    }
}
