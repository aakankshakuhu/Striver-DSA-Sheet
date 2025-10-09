import java.util.Arrays;

public class NextPermutation {

    public static void optimalapproach(int arr[], int n) {
        int idx= -1;
        for(int i = n-2; i >=0; i--) {
            if(arr[i] < arr[i+1]) {
                idx = i;
                break;
            }
        }
        if(idx == -1) {
            Arrays.sort(arr);
            System.out.println(Arrays.toString(arr));
            return;
        }
        for(int i = n-1; i >= 0; i--) {
            if(arr[i] > arr[idx]) {
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
                break;
            }
        }
        int left = idx+1, right = n-1;
        while (left < right){
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            left++;
            right--;
        }

        
        System.out.println(Arrays.toString(arr));
    }
    
    public static void main(String args[]) {
        int arr[] = {1,3,5,4,2};
        int n = arr.length;
        optimalapproach(arr, n);
    }
}
