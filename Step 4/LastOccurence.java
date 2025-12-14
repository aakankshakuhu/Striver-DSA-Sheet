public class LastOccurence {

    public static int myapproach(int arr[], int n, int target){
        int low = 0, high = n-1, ans = -1;
        while(low <= high){
            int mid = (low + high)/ 2;
            if(arr[mid] > target){
                high = mid-1;
            }
            else if(arr[mid] < target){
                low = mid+1;
            }
            else{
                ans = mid;
                low = mid+1;
            }
        }
        return ans;
    }
    
    public static void main(String args[]){
        int arr[] = {3, 13, 13, 13, 13, 20, 40};
        int n = arr.length;
        int target = 60;
        System.out.println("Last occurence of the target lemenet in the given array is at index: " + myapproach(arr, n, target));
    }
}
