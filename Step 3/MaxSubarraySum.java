public class MaxSubarraySum {
    
    public static int threeloopsapproach(int arr[], int n) {
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int sum = 0;
                for(int k = i; k <= j; k++) {
                    sum = sum + arr[k];
                }
                maxi = Math.max(maxi, sum);
            }
        }
        return maxi;
    }

    public static int twoloopsapproach(int arr[], int n) {
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++){
                sum += arr[j];
                maxi = Math.max(maxi, sum);
            }
        }
        return maxi;
    }

    //Kadane's Algorithm
    public static int kadanealgo(int arr[], int n) {
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0, ansStart = -1, ansEnd = -1;
        for(int i = 0; i < n; i++) {
            if (sum == 0)
                start = i;

            sum += arr[i];

            if(sum > maxi) {
                maxi = sum;
                ansStart = start;
                ansEnd = i;
            }
                
            else if(sum < 0)
                sum = 0;
        }
        System.out.println("Subarray: ");
        for (int i = ansStart; i <= ansEnd; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return maxi;
    }


    public static void main(String args[]) {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        int n = arr.length;
        System.out.println("Maximum subarray sum: " + kadanealgo(arr, n));
    }
}
