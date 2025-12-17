public class CapacityToShipWithinDDays {

    public static int myapproach(int arr[], int n, int days){
        int low = maxElm(arr, n), high = sumOfElm(arr, n), ans = Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(noOfDays(arr, n, days, mid) <= days){
                ans = Math.min(ans, mid);
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    public static int noOfDays(int arr[], int n, int days, int mid){
        int weights = 0, dayCnt = 1;
        for(int i = 0; i < n; i++){
            if(weights + arr[i] <= mid){
                weights += arr[i];
            }else{
                dayCnt++;
                weights = arr[i];
            }
        }
        return dayCnt;
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

    public static int sumOfElm(int arr[], int n){
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
        }
        return sum;
    }


    
    public static void main(String args[]){
        int arr[] = {1, 2, 3, 4, 5};
        int n = arr.length;
        int days = 2;
        System.out.println("Least weight capacity so that weights can be shipped in D days: " + myapproach(arr, n, days));

    }
}
