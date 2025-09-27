import java.util.HashMap;

public class NumberAppearsOnce {

    public static int hashmapapproach(int arr[], int n){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int key = arr[i];
            int freq = 0;
            if(map.containsKey(key)){
                freq = map.get(key);
            }
            freq++;
            map.put(key, freq);
        }
        for(HashMap.Entry<Integer, Integer> it: map.entrySet()){
            if(it.getValue() == 1){
                return it.getKey();            }
        }
        return -1;
    }

    public static int xorapproach(int arr[], int n){
        int xor = 0;
        for(int i = 0; i < n; i++){
            xor = xor ^ arr[i];
        }
        return xor;
    }
    
    public static void main(String args[]){
        int arr[] = {4,1,2,1,2};
        int n = arr.length;
        System.out.println("Number which appears only once: " + xorapproach(arr, n));
    }
}
