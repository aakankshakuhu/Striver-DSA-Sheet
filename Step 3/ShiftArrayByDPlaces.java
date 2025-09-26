import java.util.Arrays;

public class ShiftArrayByDPlaces {
    
    public static void myapproach(int arr[], int n, String choice, int k){
        k = k % n;
        int[] temp = new int[n];
        switch (choice) {
            case "left" ->{
                for(int i = 0; i < n; i++){
                    int idx = i - k;
                    if(idx < 0){
                        idx = idx + n;
                    }
                    temp[idx] = arr[i];
                }
            }
            
            case "right" ->{
                for(int i = 0; i < n; i++){
                    int idx = i + k;
                    if (idx >= n){
                        idx = idx - n;
                    }
                    temp[idx] = arr[i];
                }
            }
            default -> System.out.println("Invalid Choice");
        }
        for(int i = 0 ; i < n; i++)
            arr[i] = temp[i];
        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(int arr[], int start, int end){
            while(start < end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
    public static void reversalalogo(int arr[], int n, String choice, int k){
        k %= n;
        
        switch (choice) {
            case "left" ->{
                //first k elements
                reverse(arr, 0, k-1);

                //last n-k elements
                reverse(arr, k, n-1);

                //full array
                reverse( arr, 0, n-1);
            }

            case "right" ->{
                //first n-k elements
                reverse(arr, 0, n-k-1);

                //last k elements
                reverse(arr, n-k, n-1);

                //full array
                reverse(arr, 0, n-1);
            }

            default -> System.out.println("Invalid Choice");
        }
    }
    

    public static void main(String args[]){
        int[] arr = {29, 10, 14, 37, 24};
        int n = arr.length;
        String choice = "right";
        int k = 2;
        reversalalogo(arr, n, choice, k);
        System.out.println("Shifted array: " + Arrays.toString(arr));
    }
}