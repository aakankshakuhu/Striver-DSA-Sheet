import java.util.*;
public class SubsetSum {

    public static void recursive(int index, int[] arr, int currentSum, List<Integer> sums){
        if(index >= arr.length){
            sums.add(currentSum);
            return;
        }

        recursive(index+1, arr, currentSum+arr[index], sums);
        recursive(index+1, arr, currentSum, sums);
    }

    public static void main(String args[]){
        int[] arr = {5, 2, 1};
        List<Integer> sums = new ArrayList<>();
        recursive(0, arr, 0, sums);
        Collections.sort(sums);
        System.out.println(sums);

    }
    
}
