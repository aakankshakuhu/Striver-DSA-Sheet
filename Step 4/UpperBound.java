public class UpperBound {

    public static int binarysearch(int arr[], int n, int x) {
        int low = 0, high  = n-1, ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] > x){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

     public static void main(String args[]) {
        int arr[] = {3,5,8,9,15,19};
        int n = arr.length;
        int x = 9;
        System.out.println("Index: " + binarysearch(arr, n, x));
    }
}
