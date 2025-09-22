import java.util.Scanner;
public class ReverseNo {
    static int num;

    //my initial approach
     public static int countDigits(){
        int n = num;
        int count = 0;
        while(n != 0){
            int lastdig = n % 10;
            count++;
            n = n/10;
        }
        return count;
    }
    public static int reverse(){
        int count = countDigits();
        int n = num;
        int rev = 0;
        while(n != 0){
            int lastdig = n % 10;
            rev = rev + (int)(lastdig*(Math.pow(10, (count-1))));
            count--;
            n = n/10;
        }
        return rev;
    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Input: ");
        num = in.nextInt();
        // System.out.println("Reverse of number: " + reverse());
        
        //optimal approach
        int rev = 0;
        while(num != 0){
            int lastdig = num % 10;
            rev = rev*10 + lastdig;
            num = num/10;
        }
        System.out.println("Reverse of number: " + rev);
    }
}
