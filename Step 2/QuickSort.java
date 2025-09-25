import java.util.Arrays;
public class QuickSort {

    public static int partition(int arr[], int low, int high){
        int pivot = arr[high];
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = temp;
        arr[high] = temp;
        return i;
    }

    public static void quickSort(int arr[], int low, int high){
        if(low < high){
            int pivotIdx = partition(int arr[], int low, int high);
            quickSort(arr, low, pivotIdx-1);
            quickSort(arr, pivotIdx+1, high);
        }
    }

    public static void main(String args[]){
        int[] arr = {29,10,14,37,14};
        int n = arr.length;
        quickSort(arr, 0, n);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
