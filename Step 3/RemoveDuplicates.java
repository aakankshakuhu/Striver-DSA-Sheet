import java.util.HashSet;
public class RemoveDuplicates {

    public static int hashsetapproach(int arr[], int n){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(arr[i]);
        }
        int k = set.size();
        int j =0;
        for(int x: set){
            arr[j++] = x;
        }
        return k;
    }

    public static int twopointersapproach(int arr[], int n){
        int i = 0;
        for(int j = 1; j < n; j++){
            if(arr[j] != arr[i]){
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
    }

    public static void main(String args[]){
        int[] arr= {1,1,2,2,2,3,3};
        int n = arr.length;
        // int k = hashsetapproach(arr, n);
        int k = twopointersapproach(arr, n);
        for(int i = 0; i < k; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
