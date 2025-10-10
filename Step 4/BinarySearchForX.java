

public class BinarySearchForX {

    public static int iterativeapproach(int arr[], int n, int target) {
        int low = 0, high = n-1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(target == arr[mid]) {
                return mid;
            }
            else if(target < arr[mid]){
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return -1;
    }

    public static int recursiveapproach(int arr[], int n, int target) {
        return recursive(arr, 0, n-1, target);
    }

    public static int recursive(int arr[], int low, int high, int target) {
        int mid = (low+high)/2;
        if(low > high)  return -1;

        if(target == arr[mid])
            return mid;
        else if(target < arr[mid])  
            return recursive(arr, low, mid-1, target);
        else if(target > arr[mid])
            return recursive(arr, mid+1, high, target);
        return -1;
    }

    public static void main(String args[]) {
        int arr[] = {3, 4, 6, 7, 9, 12, 16, 17};
        int n = arr.length;
        int target = 12;
        int res = recursiveapproach(arr, n, target);
        if(res == -1)
            System.out.println("Number is not present in the array.");
        else    
            System.out.println("Number is present at index: " + res);
    }
}
