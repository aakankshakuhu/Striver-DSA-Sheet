public class SecondSmallestLargest {

    public static int seclargest(int arr[], int n){
        int fir = Integer.MIN_VALUE;
        int sec = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            if(arr[i] > fir){
                sec = fir;
                fir = arr[i];
            }
            else if(arr[i] > sec && arr[i] != fir){
                sec = arr[i];
            }
        }

        if (sec == Integer.MIN_VALUE){
            System.out.println("No second largest element found. All elements may be same.");
            return Integer.MIN_VALUE;
        }
        return sec;
    }

    public static int secsmallest(int arr[], int n){

        int fir = Integer.MAX_VALUE;
        int sec = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(arr[i] < fir){
                sec = fir;
                fir = arr[i];
            }
            else if(arr[i] < sec && arr[i] != fir){
                sec = arr[i];
            }
        }
        if (sec == Integer.MAX_VALUE){
            System.out.println("No second smallest element found. All elements may be same.");
            return Integer.MAX_VALUE;
        }
        return sec;
    }

    public static void main(String args[]){
        int[] arr = {29, 10, 14, 37, 24};
        int n = arr.length;
        System.out.println("Second largest number: " + seclargest(arr, n));
        System.out.println("Second smallest number: " + secsmallest(arr, n)); 
    }
}
