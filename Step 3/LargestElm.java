public class LargestElm {

    public static void bruteforce(int arr[], int n){
        int max = arr[0];
        for(int i = 1; i < n; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println("Largest Element: " + max);
    }

    public static int recursion(int arr[], int n){
        if(n == 0){
            return arr[0];
        }
        //comparig last element with the max of the rest of the array
        return Math.max(arr[n-1], recursion(arr, n-1));
    }

    public static void main(String args[]){
        int[] arr = {29,10,14,37,24};
        int n = arr.length;
        // bruteforce(arr, n);
        System.out.println("Largest Element: " + recursion(arr, n));
        
    }
}
