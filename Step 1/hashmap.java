import java.util.HashMap;
import java.util.Scanner;
public class hashmap {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the value of n: ");
        int n = in.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements: ");
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }

        //precomputing
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i = 0; i < n; i++){
            int key = arr[i];
            int freq = 0;
            if(hash.containsKey(key)){
                freq=hash.get(key);
            } 
            freq++;
            hash.put(key, freq);
        }

        //queries
        //taking query input
        System.out.println("Enter number of queries: ");
        int q = in.nextInt();
        System.out.println("Query: ");
        while(q-- != 0){
            int num = in.nextInt();
            //fetching
            if(hash.containsKey(num)){
                System.out.print("Frequency: ");
                System.out.println(hash.get(num));
            }
            else{
                System.out.print("Frequency: ");
                System.out.println("0");
            }
        }
    }
    
}
