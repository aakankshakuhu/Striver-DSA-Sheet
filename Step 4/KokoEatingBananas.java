public class KokoEatingBananas {

    public static int myapproach(int arr[], int n, int h){
        int low = 1, high = maxElm(arr, n), ans = Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high-low)/2;
            int time = calcTime(arr, n, mid);
            if(time > h){
                low = mid+1;
            }
            else if(time <= h){
                ans = Math.min(ans, mid);
                high = mid-1;
            }
        }
        return ans;
    }

    public static int calcTime(int arr[], int n, int mid){
        int time = 0;
        for(int i = 0; i < n; i++){
            time += Math.ceil((double)arr[i] / mid);
        }
        return time;
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
        int arr[] = {25, 12, 8, 14, 19};
        int n = arr.length;
        int h = 5;
        System.out.println("Minimum bananas per hour that Koko can eat: " + myapproach(arr, n, h));
    }
}
