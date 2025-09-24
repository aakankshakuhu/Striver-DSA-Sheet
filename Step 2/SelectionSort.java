import java.util.Arrays;

public class SelectionSort {

    public static void usingtwoloops(int arr[], int n){
        System.out.println("Initial array: "+Arrays.toString(arr));
        for(int i = 0; i < n-1; i++){
            int minIdx = i;
            for(int j = i+1; j < n; j++){
                if(arr[j] < arr[minIdx]){
                    int temp = arr[minIdx];
                    arr[minIdx] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("Sorted array: "+ Arrays.toString(arr));
    }

    public static void usingrecursion(int arr[], int startIdx, int n){
        if (startIdx >= n-1)
            return;
        int minIdx = startIdx;
        for(int i = startIdx+1; i < n; i++){
            if(arr[i] < arr[minIdx]){
                minIdx = i;
            }
        }
        int temp = arr[startIdx];
        arr[startIdx] = arr[minIdx];
        arr[minIdx] = temp;

        usingrecursion(arr, startIdx + 1, n);

    }
    public static void main(String args[]){
        int[] arr = {29,10,14,37,14};
        int n = arr.length;
        // usingtwoloops(arr, n);
        usingrecursion(arr, 0, n);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}

