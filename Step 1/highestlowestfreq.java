import java.util.HashMap;
import java.util.Map;
public class highestlowestfreq {

    public static void usingloops(int arr[], int n){

        int maxFreq = 0, minFreq = n;
        int maxElm = 0, minElm = 0;
        boolean visited[] = new boolean[n];
        for(int i = 0; i < n; i++){
            if(visited[i] == true)
                continue;
            
            int count = 1;
            for(int j = i+1; j < n; j++){
                if(arr[i] == arr[j]){
                    visited[j] = true;
                    count++;
                }
            }
            if(count > maxFreq){
                maxElm = arr[i];
                maxFreq = count;
            }
            if(count < minFreq){
                minElm = arr[i];
                minFreq = count;
            }
        }
        System.out.println("The highest frequency is of element "+maxElm+" and its frequency is "+maxFreq);
        System.out.println("The lowest frequency is of element "+minElm+" and its frequency is "+minFreq);
    }

    public static void usinghashmap(int [] arr, int n){
        int maxFreq = 0, minFreq = n;
        int maxElm = 0, minElm = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }
            else{
                map.put(arr[i], 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > maxFreq){
                maxElm = entry.getKey();
                maxFreq = entry.getValue();
            }
            if(entry.getValue() < minFreq){
                minElm = entry.getKey();
                minFreq = entry.getValue();
            }
        }
        System.out.println("The highest frequency is of element "+maxElm+" and its frequency is "+maxFreq);
        System.out.println("The lowest frequency is of element "+minElm+" and its frequency is "+minFreq);
    }
    public static void main(String args[]){
        int[] arr={5,10,15,5,5,10};
        int n = arr.length;
        usinghashmap(arr, n);

    }
}
