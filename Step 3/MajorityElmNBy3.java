import java.util.HashMap;
import java.util.Map;
public class MajorityElmNBy3 {
    
    public static String bruteforce(int arr[], int n) {
        int nby3 = n/3;
        String ans = "";
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            cnt = 1;
            for(int j = i+1; j < n; j++) {
                if(arr[i] == arr[j]){
                    cnt += 1;
                }
            }
            if(cnt > nby3){
                ans = ans + arr[i]+ " ";
            }
        }
        return ans;
    }

    public static String hashingapproach(int arr[], int n) {
        int nby3 = n/3;
        String ans = "";
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int value = map.getOrDefault(arr[i], 0);
            map.put(arr[i], value+1);
        }

        for(Map.Entry<Integer, Integer> x: map.entrySet()) {
            if (x.getValue() > nby3){
                ans += x.getKey()+ " ";
            }
        }
        return ans;
    }

    public static String moorevotingalgo(int arr[], int n) {
        int cnt1 = 0, cnt2 = 0, elm1 = 0, elm2 = 0;
        String ans = "";
        for(int i = 0; i < n; i++) {
            
            if(cnt1 == 0 && arr[i] != elm2) {
                elm1 = arr[i];
                cnt1++;
            }
            else if(cnt2 == 0 && arr[i] != elm1) {
                elm2 = arr[i];
                cnt2++;
            }
            else if(elm1 == arr[i]){
                cnt1 += 1;
            }
            else if(elm2 == arr[i]){
                cnt2 += 1;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }
        int count1 = 0, count2 = 0;
        for(int num: arr) {
            if(num == elm1) count1++;
            else if(num == elm2) count2++;
        }
        if(count1 > n/3)    ans = ans+elm1+' ';
        if(count2 > n/3)    ans = ans+elm2+' ';
        return ans;
    }
    public static void main(String args[]) {
        int arr[] = {11,33,33,11,33,11};
        int n = arr.length;
        System.out.println(moorevotingalgo(arr, n));
    }
}
