import java.util.Arrays;

public class CheckSorted {

    public static boolean myapproach(int arr[], int n){
        
        for(int i = 0; i < n-1; i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
        
    }
    public static void main(String args[]){
        int[] arr = {1, 5, 3, 4, 5};
        int n = arr.length;
        System.out.println(Arrays.toString(arr));
        System.out.println(myapproach(arr, n));
    }
}
