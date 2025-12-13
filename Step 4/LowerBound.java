public class LowerBound {

    public static int myapproach(int arr[], int n, int x) {
        for(int i = 0; i < n; i++) {
            if(arr[i] >= x){
                return i;
            }
        }
        return -1;
    }

    public static int binarysearch(int arr[], int n, int x){
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

    public static void main(String args[]) {
        int arr[] = {3, 5, 8, 15, 19, 88, 99, 100, 101};
        int n = arr.length;
        int x = 9;
        System.out.println("Index: " + binarysearch(arr, n, x));
    }
}
