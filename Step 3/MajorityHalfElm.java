import java.util.HashMap;
import java.util.Map;
public class MajorityHalfElm {

    public static int hashmapapproach(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int half = n/2;
        for(int i = 0; i < n; i++) {
          int value = map.getOrDefault(arr[i], 0);
          map.put(arr[i], value+1);
        }
        for(Map.Entry<Integer, Integer> x: map.entrySet()) {
            if(x.getValue() > half) {
                return(x.getKey());
            }
        }
        return -1;
    }

    public static int moorevotingalgo(int arr[], int n) {
        int cnt = 0;
        int elm = 0;
        for(int i = 0; i < n; i++) {
            if(cnt == 0){
                elm = arr[i];
                cnt = cnt+1;
            }
            else if(elm == arr[i])
                cnt = cnt+1;
            else
                cnt = cnt-1;  
        }
        int cnt1 = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == elm)
                cnt1++;
        }
        if(cnt1 > (n/2)){
            return elm;
        }
        return -1;
    }
    
    public static void main(String args[]) {
        int[] arr = {4,4,2,4,3,4,4,3,2,4};
        int n = arr.length;
        System.out.println("Majority element that occurs more than n/2 times: "+ moorevotingalgo(arr, n));
    }
}
