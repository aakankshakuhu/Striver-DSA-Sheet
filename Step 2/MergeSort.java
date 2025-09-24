import java.util.Arrays;

public class MergeSort{

    public static void conquer(int arr[], int startIdx, int mid, int endIdx){
        int merged[] = new int[endIdx - startIdx + 1];

        int left = startIdx;
        int right = mid + 1; 
        int x = 0;

        while(left <= mid && right <= endIdx){
            if(arr[left] < arr[right]){
                merged[x++] = arr[left++]; 
            }
            else{
                merged[x++] = arr[right++];
            }
        }

        //if elements still left
        while(left <= mid){
            merged[x++] = arr[left++];
        }
        while(right <= endIdx){
            merged[x++] = arr[right++];
        }

        //copying elem from merged array into original array
        for(int i = 0, j = startIdx; i < merged.length; i++, j++){
            arr[j] = merged[i];
        }

    }

    public static void divide(int arr[], int startIdx, int endIdx){
        if(startIdx >= endIdx){
            return;
        }
        int mid = startIdx + (endIdx-startIdx)/2;
        divide(arr, startIdx, mid);
        divide(arr, mid+1, endIdx);
        conquer(arr, startIdx, mid, endIdx);
    }

    

    public static void main(String args[]){
        int[] arr = {29,10,14,37,14};
        int n = arr.length;
        divide(arr, 0, n-1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}