import java.util.Scanner;
public class Palindrome {
    static int num;
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Input: ");
        num = in.nextInt();
        int n = num;
        int rev = 0;
        while(n != 0){
            int lastdig = n % 10;
            rev = rev*10 + lastdig;
            n = n/10;
        }
        if(rev == num){
            System.out.println("Palindrome number.");
        }
        else{
            System.out.println("Not a Palindrome number.");
        }
    }
}
