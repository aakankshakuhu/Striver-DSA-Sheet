import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
public class FourSum {

    public static List<List<Integer>> bruteforce(int arr[], int n, int target) {
        HashSet<List<Integer>> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                for(int k = j+1; k < n; k++) {
                    for(int l = k+1; l < n; l++) {
                        if((arr[i] + arr[j] + arr[k] + arr[l]) == target){
                            List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                            temp.sort(null);
                            set.add(temp);
                        }
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }

    public static List<List<Integer>> betterapproach(int arr[], int n, int target) {
        HashSet<List<Integer>> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                HashSet<Integer> hashset = new HashSet<>();
                for(int k = j+1; k < n; k++) {
                    int fourth = target- (arr[i]+arr[j]+arr[k]);
                    if(hashset.contains(fourth)) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], fourth);
                        temp.sort(null);
                        set.add(temp);
                    }
                    hashset.add(arr[k]);
                }
            } 
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }

    public static List<List<Integer>> optimalapproach(int arr[], int n, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        for(int i = 0; i < n; i++) {
            if(i != 0 && arr[i] == arr[i-1]) continue;

            for(int j = i+1; j < n; j++) {
                if(j > i+1 && arr[j] == arr[j-1]) continue;

                int k = j+1;
                int l = n-1;

                while(k < l){
                    int sum = arr[i] + arr[j] + arr[k] + arr[l];
                    if(sum == target){
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                        ans.add(temp);
                        k++;
                        l--;

                        while(k < l && arr[k] == arr[k-1]) k++;
                        while(k < l && arr[l] == arr[l+1]) l--;
                    }
                    else if(sum < target)
                        k++;
                    else 
                        l--;
                }
            }
        }
        return ans;
    }
    
    public static void main(String args[]) {
        int arr[] = {1,0,-1,0,-2,2};
        int n = arr.length;
        int target = 0;
        System.out.println(optimalapproach(arr, n, target));
    }
}
