import java.util.HashMap;
public class RepeatingAndMissingNumber {

    public static void bruteforce(int arr[], int n){
        for(int i = 1; i <= n; i++){
            int cnt = 0;
            for(int j = 0; j < n; j++){
                if(arr[j]==i)   cnt++;
            }
            if(cnt == 2) {
                System.out.println("Repeating number: " + i);
            }    
            else if (cnt == 0)  System.out.println("Missing number: " + i);
        }
    }

    public static void hasharray(int arr[], int n) {
        int hash[] = new int[n+1];
        for(int i = 0; i < n; i++){
            hash[arr[i]]++;
        }

        for(int i = 1; i <= n; i++){
            if(hash[i] == 2){
                System.out.println("Repeating number: " + i);
            }
            else if(hash[i] == 0){
                System.out.println("Missing number: " + i);
            }
        }
    }

    public static void hashmap(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            int key = arr[i];
            map.put(key, map.getOrDefault(key, 0)+ 1);
        }

        for(int i = 1; i <= n; i++){
            if(!map.containsKey(i)){
                System.out.println("Missing number: " + i);
            }
            else if(map.get(i) == 2){
                System.out.println("Repeating number: " + i);
            }
        }
    }

    public static void mathematics(int arr[], int n) {
        long Sn = (n*(n+1))/2;
        long S2n = (n*(n+1)*(2*n+1))/6;

        long S = 0, S2 = 0;
        for(int i = 0; i < n; i++){
            S += arr[i];
            S2 += (long)arr[i] * (long)arr[i];
        }

        //s-sn = x - y
        long val1 = S - Sn;

        //s2-s2n = x2 - y2
        long val2 = S2 - S2n;

        //x+y = (x2-y2)/(x-y)
        val2 = val2 / val1;

        //x = repeating number
        //y = missing number
        long x = (val1 + val2)/2;
        long y = x - val1;

        System.out.println("Repeating number: " + x);
        System.out.println("Missing Number: " + y);
    }

    public static void xor(int arr[], int n) {
        int xr = 0;

        //XOR of all elements
        for(int i = 0; i < n; i++){
            xr = xr ^ arr[i];
            xr = xr ^ (i+1);
        }

        //find the differentitating bit
        int num = (xr & ~(xr - 1));

        //group the numbers
        int zero = 0;
        int one = 0;
        for(int i = 0; i < n; i++) {
            //part of 1 group
            if ((arr[i] & num) != 0) {
                one = one ^ arr[i];
            }

            //part of zero group
            else{
                zero = zero ^ arr[i];
            }
        }

        for(int i = 1; i <= n; i++) {
            //part of 1 group
            if((i & num) != 0) {
                one =  one ^ i;
            }
            //part of 0 group
            else{
                zero = zero ^ i;
            }
        }

        //identify numbers
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == zero)  cnt++;
        }

        if (cnt == 2) {
            System.out.println("Repeating number: " + zero);
            System.out.println("Missing Number: " + one);
        }
        else{
            System.out.println("Repeating number: " + one);
            System.out.println("Missing Number: " + zero);
        }

    }


    public static void main(String args[]){
        int arr[] = {3,1,2,5,4,6,7,5};
        int n = arr.length;
        xor(arr, n);
    }
    
}
