import java.util.Scanner;
public class ReverseArray {

    public static void extraArray(int arr[], int n){
        int[] arrnew = new int[n];
        for(int i = 0; i < n; i++){
            arrnew[i] = arr[(n-1)-i];
        }
        System.out.println("Reversed Array: ");
        for(int i = 0; i < n; i++){
            System.out.print(arrnew[i]+ " ");
        }
    }

    public static void sameArray(int arr[], int n){
        for(int i = 0; i < n/2; i++){
            int temp = arr[i];
            arr[i] = arr[(n-1)-i];
            arr[(n-1)-i] = temp;
        }
        System.out.println("Reversed Array: ");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i]+ " ");
        }
    }

    public static void recursiveReverseArray(int arr[], int start, int end){
        if( start >= end){
            System.out.println("Reversed Array: ");
            for(int i = 0; i < arr.length; i++){
                System.out.print(arr[i]+ " ");
            }
            return;
        }
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        recursiveReverseArray(arr, start+1, end-1);
    }

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter length of array: ");
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array: ");
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        System.out.println("Original array: ");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
        
    }
}
