
import java.util.Arrays;

public class BubbleSort {

    public static void usingloops(int arr[], int n){
        System.out.println("Initial Array: " + Arrays.toString(arr));
        for(int i = 0; i < n-1; i++){
            int swapped = 0;
            for(int j = 0; j < n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    swapped = 1;
                }
            }
            if(swapped == 0){
                break;
            }
        }
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    public static void usingrecursion(int arr[], int n){
        if(n <= 1){
            return;
        }
        for(int i = 0; i < n-1; i++){
            if(arr[i] > arr[i+1]){
                int temp = arr[i+1];
                arr[i+1] = arr[i];
                arr[i] = temp;
            }
        }
        usingrecursion(arr, n-1);
        
    }

     public static void main(String args[]){
        int[] arr = {29,10,14,37,14};
        int n = arr.length;
        // usingloops(arr, n);
        usingrecursion(arr, n);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
