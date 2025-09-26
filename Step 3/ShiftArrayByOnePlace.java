
import java.util.Arrays;

public class ShiftArrayByOnePlace {
    
    public static void myapproach(int arr[], int n){
        int temp = arr[0];
        for(int i = 1; i < n; i++){
            arr[i - 1] = arr[i];
        }
        arr[n-1] = temp;
    }

    public static void main(String args[]){
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;
        myapproach(arr, n);
        System.out.println(Arrays.toString(arr));
    }
}
