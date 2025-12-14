public class CountOccurences {

    public static int lastoccurence(int arr[], int n, int target){
        int low = 0, high = n-1, last_occ = -1;
        while(low <= high){
            int mid = (low + high)/ 2;
            if(arr[mid] > target){
                high = mid-1;
            }
            else if(arr[mid] < target){
                low = mid+1;
            }
            else{
                last_occ = mid;
                low = mid+1;
            }
        }
        return last_occ;
    }

        public static int firstoccurence(int arr[], int n, int target){
        int low = 0, high = n-1, first_occ = -1;
        while(low <= high){
            int mid = (low + high)/ 2;
            if(arr[mid] > target){
                high = mid-1;
            }
            else if(arr[mid] < target){
                low = mid+1;
            }
            else{
                first_occ = mid;
                high = mid-1;
            }
        }
        return first_occ;
    }

    
    public static void main(String args[]){
        int arr[] = {2, 2 , 3 , 3 , 3 , 3 , 4};
        int n = arr.length;
        int x = 3;
        int ans = lastoccurence(arr, n, x) - firstoccurence(arr, n, x) + 1;
        System.out.println("Total number of occurences: " + ans);
    }
}
