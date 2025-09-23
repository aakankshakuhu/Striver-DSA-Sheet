import java.util.Scanner;
public class fibonacci {

    public static void iterativeapproach(int n){
        if(n == 0){
            System.out.println("0");
        }
        if(n == 1){
            
        }
        if(n > 1){
            System.out.print("0, 1, ");
            int a = 0;
            int b = 1;
            for(int i = 0; i <= n-2; i++){
                int sum = a + b;
                System.out.print(sum + ", ");
                a = b;
                b = sum;
            }

        }
    }

    public static int recursiveapproach(int n){
        if(n <= 1){
            return n;
        }
        else{
            int last = recursiveapproach(n - 2);
            int first = recursiveapproach(n - 1);
            return last+first;
        }
        }

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number.");
        int n = in.nextInt();
        iterativeapproach(n);
    }
    
}
