public class HowManyTimesArrayRotated {

    public static int myapproach(int arr[], int n){
        int low = 0, high = n-1;
        while(low < high){
            int mid = low + (high - low)/2;
            if(arr[mid] < arr[high]){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
    
    public static void main(String args[]){
        int arr[] = {4,5,6,7,0,1,2,3};
        int n = arr.length;
        System.out.println("Number of times array has been rotated: " + myapproach(arr, n));
    }
    
}
