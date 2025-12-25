public class RowWithMaxNoOfOnes {

    public static int bruteforce(int arr[][], int n, int m){
        int cnt_max = 0;
        int min_idx = -1;
        for(int i = 0; i < n; i++){
            int cnt_ones = 0;
            for(int j = 0; j < m; j++){
                cnt_ones += arr[i][j];

                if(cnt_ones > cnt_max){
                    cnt_max = cnt_ones;
                    min_idx = i;
                }
            }
        }
        return min_idx;
    }

    public static int binarysearch(int arr[][], int n, int m){
        int cnt_max = 0;
        int min_idx = -1;
        for(int i = 0; i < n; i++){
            int cnt_ones = m - lowerbound(arr[i], m, 1);
            if(cnt_ones > cnt_max){
                cnt_max = cnt_ones;
                min_idx = i;
            }
        }
        return min_idx;
    }

    public static int lowerbound(int arr[], int n, int x){
        int low = 0, high = n-1, ans = n;
        while(low <= high) {
            int mid = (high+low)/2;
            if(arr[mid] >= x){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    
    public static void main(String args[]){
        int arr[][] = {{0, 1, 1}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        int n = 4, m = 3;
        System.out.println("Row with maximum number of ones: " + binarysearch(arr, n, m));
    }
}
