import java.util.Scanner;
public class Armstrong {
    static int num; 

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

    public static int armstrong(){
        int count = countDigits();
        int n = num;
        int newnum = 0;
        while(n != 0){
            int dig = (int)(Math.pow((n % 10), count));
            newnum = newnum + dig;
            n = n/10; 
        }
        return newnum;
    }
    public static void main(String args[]){
        Scanner in =new Scanner(System.in);
        System.out.println("Input: ");
        num = in.nextInt();
        int result = armstrong();
        if(num == result){
            System.out.println("Armstrong number");
        }
        else{
            System.out.println("Not an Armstrong number");
        }
        
    }
    
}
