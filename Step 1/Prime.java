import java.util.Scanner;
public class Prime {
    static int num;

    //brute force
    public static boolean primebrute(){
        int count = 0;
        for(int i = 1; i <= num; i++){
            if(num % i == 0){
                count++;
            }
        }
        if(count == 2){
            return true;
        }
        else{
            return false;
        }
    }
    //optimal approach
    public static boolean primeoptimal(){
        int count = 0;
        for(int i = 1; i*i <= num; i++){
            if(num % i == 0){
                count++;
                if(num/i != i){
                    count++;
                }
            }
        }
        if(count == 2){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Input: ");
        num = in.nextInt();
        System.out.println("Prime Number: " + primeoptimal());

    }
}
