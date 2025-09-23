import java.util.Scanner;
public class characterhashing {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String s = in.next();

        //precompute
        int[] hash = new int[26];
        for(int i = 0; i < s.length(); i++){
            hash[s.charAt(i) - 'a']++;
        }

        //queries
        System.out.println("Enter number of queries: ");
        int q = in.nextInt();
        System.out.println("Query: ");
        while(q-- != 0){
            char c = in.next().charAt(0);
            System.out.print("Frequency: ");
            //fetch
            System.out.println(hash[c - 'a']);
        }
    }
}
