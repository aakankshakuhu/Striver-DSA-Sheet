import java.util.Arrays;
import java.util.HashSet;
public class LongestConsecSeq {

    public static int bruteforce(int arr[], int n) {
        int longest = 1;
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            int x = arr[i];
            cnt = 1;
            while(linearsearch(arr,n, x+1) != false){
                cnt += 1;
                x += 1;
            }
            longest = Math.max(longest, cnt);
        }
        return longest;
    }
    private static boolean linearsearch(int arr[],int n, int num) {
        for(int i = 0; i < n; i++){
            if(arr[i] == num){
                return true;
            }
        }
        return false;
    }

    public static int betterapproach(int arr[], int n) {
        int lastSmaller = Integer.MIN_VALUE;
        int cnt = 0;
        int longest = 1;
        Arrays.sort(arr);
        for(int i = 0; i < n; i++) {
            if(arr[i]-1 == lastSmaller) {
                lastSmaller = arr[i];
                cnt += 1;
            }
            else if(arr[i] != lastSmaller) {
                cnt = 1;
                lastSmaller = arr[i];
            }
            longest = Math.max(cnt, longest);
        }
        return longest;
    }

    public static int optimalapproach(int arr[], int n) {
        int cnt = 0; 
        int longest = 1;
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            set.add(arr[i]);
        }

        for(int it: set) {
            if(!set.contains(it-1)){
                cnt = 1;
                int x = it;
                while(set.contains(x+1)){
                    x = x+1;
                    cnt = cnt+1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }

    
    public static void main(String args[]) {
        int[] arr = {100, 102, 100, 101, 101, 6, 5, 5, 4, 3, 2, 3, 2, 1, 1, 1, 2};
        int n = arr.length;
        System.out.println(optimalapproach(arr, n));
        
    }
}
