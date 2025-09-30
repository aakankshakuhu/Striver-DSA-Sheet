import java.util.ArrayList;
import java.util.Collections;
public class LeaderInArray {
    
    public static void bruteforce(int arr[], int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            boolean leader = true;
            for(int j = i+1; j < n; j++) {
                if(arr[j] > arr[i]) {
                    leader = false;
                    break;
                }      
            }if(leader){
                ans.add(arr[i]);
            }
        }
        System.out.println(ans);
    }

    public static void optimalapproach(int arr[], int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        int greatest = arr[n-1];
        ans.add(greatest);
        for(int i = n-2; i >= 0; i--) {
            if(arr[i] > greatest) {
                greatest = arr[i];
                ans.add(greatest);
            }
        }
        Collections.reverse(ans);
        System.out.println(ans);
    }

    public static void main(String args[]) {
        int arr[] = {10, 22, 12, 3, 0, 6};
        int n = arr.length;
        optimalapproach(arr, n);
    }
}
