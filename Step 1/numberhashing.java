import java.util.Scanner;
public class numberhashing {
    public static void main(String args[]){
        Scanner in  = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = in.nextInt();
        int[] arr = new int[n];

        //taking array input
        System.out.println("Enter array elements: ");
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }

        //precompute
        int[] hash = new int[13];
        for(int i = 0; i < n; i++){
            hash[arr[i]] += 1; 
        }

        //taking query input
        System.out.println("Enter number of queries: ");
        int q = in.nextInt();
        System.out.println("Query: ");
        while(q-- != 0){
            int num = in.nextInt();
            //fetching
            System.out.print("Frequency: ");
            System.out.println(hash[num]);
        }
    }
}
