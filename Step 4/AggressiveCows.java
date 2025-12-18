import java.util.Arrays;
public class AggressiveCows {

    public static int bruteforce(int arr[], int n, int k){
        int max_distance = 0;
        for(int i = 1; i <= (arr[n-1]-arr[0]); i++){
            if(canWePlaceCows(arr, n, k, i) == true){
                max_distance = i;
            }
            else{
                return i-1;
            }

        }
        return max_distance;
    }

    public static int binarysearch(int arr[], int n, int k){
        int low = 1, high = arr[n-1] - arr[0], ans = 0;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(canWePlaceCows(arr, n, k, mid) == false){
                high = mid-1;
            }
            else{
                ans = mid;
                low = mid+1;
            }
        }
        return ans;
    }

    public static boolean canWePlaceCows(int arr[], int n, int k, int i){
        int count = 1; //first cow at the first stall
        int lastpos = arr[0];
        for(int j = 1; j < n; j++){     //loop of number of stalls
            if(arr[j] - lastpos >= i){
                count++;
                lastpos = arr[j];
            }
        }
        return (count >= k);
    }
    
    public static void main(String args[]){
        int arr[] = {4,2,1,3,6};
        int n = arr.length;
        int k = 2;
        Arrays.sort(arr); 
        System.out.println("Maximum minimum distance between cows: " + binarysearch(arr, n, k));
    }
}
