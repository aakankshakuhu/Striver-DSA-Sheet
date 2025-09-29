import java.util.Arrays;
import java.util.HashMap;
public class TwoSum {

    public static void bruteforce(int arr[], int n, int target){
        int idx1 = -1, idx2 = -1;
        boolean found = false;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if((arr[i] + arr[j]) == target){
                    idx1 = i;
                    idx2 = j;
                    found = true;
                    break;
                }
                if (found == true){
                    break;
                }
            }
        }
        if(found)
            System.out.println("{ " + idx1+ ", " + idx2+ " }");
        else
            System.out.println("Not found");
    }

    public static void hashmap(int arr[], int n, int target) {
        int idx1 = -1, idx2 = -1;
        boolean found = false;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            map.put(arr[i], i);
        }

        for(int i = 0; i < n; i++){
            int num = arr[i];
            int moreneeded = target - num;
            if(map.containsKey(moreneeded)){
                idx1 = i;
                idx2 = map.get(moreneeded);
                found = true;
                break;
            }
        }
        if (found)
            System.out.println("{ " + idx1+ ", " + idx2+ " }");
        else
            System.out.println("Not found");
    }

    public static String twopointers(int arr[], int n, int target){
        Arrays.sort(arr);
        int left = 0, right = n-1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if(sum == target){
                return "YES";
            }
            else if(sum < target){
                left++;
            }
            else if (sum > target){
                right--;
            }
        }
        return "NO";
    }
    
    public static void main(String args[]){
        int arr[] = {2,5,9,8,11};
        int n = arr.length;
        int target = 14;
        System.out.println(twopointers(arr, n, target));
    }
}
