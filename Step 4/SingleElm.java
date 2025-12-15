public class SingleElm {

    public static int myapproach(int arr[], int n){
        if(n == 1){
            return arr[0];
        }
        else if(arr[0] != arr[1]){
            return arr[0];
        }
        else if(arr[n-1] != arr[n-2]){
            return arr[n-1];
        }
        else{
            int low = 1, high = n-2;
            while(low <= high){
                int mid = low + (high-low)/2;
                if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1])    return arr[mid];
                if(mid % 2 == 0){
                    if(arr[mid] == arr[mid-1]){
                        high = mid-1;
                    }
                    else{
                        low = mid+1;
                    }
                }
                else{
                    if(arr[mid] == arr[mid+1]){
                        high = mid-1;
                    }
                    else{
                        low = mid+1;
                    } 
                }
            }
        }
        return -1;
    }
    


    public static void main(String args[]){
        int arr[] = {1,1,2,2,3,3,4,5,5,6,6};
        int n = arr.length;
        System.out.println("Single element in the sorted array: " + myapproach(arr, n));
    }
}
