import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
public class ThreeSum {
    
    public static List<List<Integer>> bruteforce(int arr[], int n) {
        HashSet<List<Integer>> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                for(int k = j+1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        temp.sort(null);
                        set.add(temp);
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }

    public static List<List<Integer>> betterapproach(int arr[], int n) {
        HashSet<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            HashSet<Integer> hashset = new HashSet<>();
            for(int j = i+1; j < n; j++) {
                int third = -(arr[i] + arr[j]);
                if(hashset.contains(third)) {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    temp.sort(null);
                    set.add(temp);
                }
                hashset.add(arr[j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }

    public static List<List<Integer>> optimalapproach(int arr[], int n) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        for(int i = 0; i < n; i++) {
            if(i != 0 && arr[i] == arr[i-1])    continue;

            int j = i+1;
            int k = n-1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if(sum < 0) {
                    j++;
                }
                else if(sum > 0){
                    k--;
                }
                else {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while(j < k && arr[j] == arr[j-1]) j++;
                    while(j < k && arr[k] == arr[k+1]) k--;
                }
            }  
        }
        return ans;
    }

    public static void main(String args[]) {
        int arr[] = {-1,0,1,2,-1,-4};
        int n = arr.length;
        System.out.println(optimalapproach(arr, n));
    }
}
