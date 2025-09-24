
import java.util.Arrays;

public class InsertionSort {

    public static void usingloops(int arr[], int n){
        System.out.println("Unsorted array: " + Arrays.toString(arr));
        for(int i = 0; i < n; i++){
            int j = i;
            while(j > 0 && arr[j-1]>arr[j]){
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        System.out.println("Sorted array: "+ Arrays.toString(arr));
    }

    public static void usingrecursion(int arr[], int i, int n){

        if(i == n){
            return;
        }

        int j = i;
        while(j > 0 && arr[j-1] > arr[j]){
            int temp = arr[j-1];
            arr[j-1] = arr[j];
            arr[j] = temp;
            j--;
        }
        usingrecursion(arr, i+1, n);
    }

    public static void main(String args[]){
        int[] arr = {29,10,14,37,14};
        int n = arr.length;
        // usingloops(arr, n);
        usingrecursion(arr, 0, n);
        System.out.println("sorted array: "+ Arrays.toString(arr));
        
    }
}
