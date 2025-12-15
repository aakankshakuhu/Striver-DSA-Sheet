public class PeakElm {
    
    public static int myapproach(int arr[], int n){
        if(n == 1){
            return n;
        }
        else if(arr[0] > arr[1]){
            return 0;
        }
        else if(arr[n-1] > arr[n-2]){
            return n-1;
        }
        else{
            int low = 1, high = n-1;
            while(low <= high){
                int mid = low + (high-low)/2;
                if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                    return mid;
                }
                else if(arr[mid] > arr[mid-1]){
                    low = mid + 1;
                }
                else if(arr[mid] > arr[mid+1]){
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String args[]){
        int arr[] = {1,2,1,3,5,6,4};
        int n = arr.length;
        System.out.println("Index of peak element: " + myapproach(arr, n));
    }
}
