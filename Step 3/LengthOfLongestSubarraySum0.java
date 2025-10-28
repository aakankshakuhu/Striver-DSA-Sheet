import java.util.HashMap;
public class LengthOfLongestSubarraySum0 {

    public static int bruteforce(int arr[], int n) {
        int len = 0;
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += arr[j];
                if(sum == 0){
                    len = Math.max(len,j-i+1);
                }
            }
        }
        return len;
    }

    public static int hashmapapproach(int arr[], int n) {
        HashMap<Integer, Integer> preSum = new HashMap<>();

        int len = 0;
        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += arr[i];

            if(sum == 0){
                len = i+1;
            }
            else {
                if(preSum.get(sum) != null){
                    len = Math.max(len, i-preSum.get(sum));
                }
                else{
                    preSum.put(sum, i);
                }
            }
        }
        return len; 
    }

    public static void main(String args[]) {
        int arr[] = {9, -3, 3, -1, 6, -5};
        int n = arr.length;
        System.out.println("Length of Longest Subarray with sum zero: " + hashmapapproach(arr, n));
    }
    
}
