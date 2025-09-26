import java.util.ArrayList;
import java.util.Arrays;
public class MoveZerosToEnd{

    public static void temparrapproach(int arr[], int n){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(arr[i] != 0){
                temp.add(arr[i]);
            }
        }
        int k = temp.size();
        for(int i = 0; i < k; i++){
            arr[i] = temp.get(i);
        }
        for(int i = k; i < n; i++){
            arr[i] = 0;
        }
    }

    public static void twopointersapproach(int arr[], int n){
        int i, j = -1;
        for(i = 0; i < n; i++){
            if(arr[i] == 0){
                j = i;
                break;
            }
        }
        if(j == -1){
            return;
        }
        for(i = j+1; i < n; i++){
            if(arr[i] != 0){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }
    }

    public static void main(String args[]){
        int arr[] = {1 ,0 ,2 ,3 ,0 ,4 ,0 ,1};
        int n = arr.length;
        twopointersapproach(arr, n);
        System.out.println(Arrays.toString(arr));
    }
}