import java.util.Arrays;
public class SortArrayOf012 {
    //Dutch National Flag Algorithm
    public static void cntvariableapproach(int[] arr, int n) {
        int a = 0, b = 0, c = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == 0)
                a += 1;
            else if(arr[i] == 1)
                b += 1;
            else 
                c += 1;
        }
        for(int i = 0; i < a; i++){
            arr[i] = 0;
        }
        for(int i = a; i < (a+b); i++){
            arr[i] = 1;
        }
        for(int i = (a+b); i < n; i++) {
            arr[i] = 2;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void threepointersapproach(int[] arr, int n) {
        int low = 0, mid = 0, high = n-1;
        while (mid <= high){
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            }
            else if(arr[mid] == 1) {
                mid++;
            }
            else if (arr[mid] == 2) {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String args[]) {
        int[] arr = {0,1,2,0,1,2,0,0,1,2};
        int n = arr.length;
        // cntvariableapproach(arr, n);
        threepointersapproach(arr, n);
    }
}
