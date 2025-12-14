public class FloorAndCeil {

    public static int floor(int arr[], int n, int x){
       int low = 0, high = n-1, ans = Integer.MIN_VALUE;
       while(low <= high){
        int mid = (low+high)/2;
        if(arr[mid] <= x){
            ans = Math.max(ans, arr[mid]);
            low = mid+1;
        }
        else{
            high = mid-1;
        }
       }
       return ans;
    }
    
    public static int ceil(int arr[], int n, int x){
        int low = 0, high = n-1, ans = n;
        while(low <= high) {
            int mid = (high+low)/2;
            if(arr[mid] >= x){
                ans = arr[mid];
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    public static void main(String args[]){
        int arr[] = {8, 12, 17, 22, 25};
        int n = arr.length;
        int x = 16;
        System.out.println("Largest element smaller that or equal to x: " + floor(arr, n, x));
        System.out.println("Smallest element greater than or equal to x: " + ceil(arr, n, x));
    }
}
