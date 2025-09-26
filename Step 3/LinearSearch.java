public class LinearSearch {

    public static int myapproach(int arr[], int n, int num){
        for(int i = 0; i < n; i++){
            if(arr[i] == num){
                return i;

            }
        }
        return -1;

    }

    public static void main(String args[]){
        int arr[] = {29, 37, 10, 14, 24};
        int n = arr.length;
        int num = 94;
        System.out.println("Element found at "+ myapproach(arr, n, num) +" index.");
    }
}
