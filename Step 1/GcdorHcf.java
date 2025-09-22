import java.util.Scanner;
public class GcdorHcf {
    static int num1, num2;
    static int min;

    //brute force approach
    public static int gcdbrute(){
        int gcd = 0;
        for(int i = 1; i <= min; i++){
            if(num1 % i == 0 && num2 % i == 0){
                gcd = i;
            }
        }
        return gcd;
    }

    //better approach
    public static int gcdbetter(){
        int gcd = 0;
        for(int i = min; i >= 1; i--){
            if(num1 % i == 0 && num2 % i == 0){
                gcd = i;
                break;
            }
        }
        return gcd;
    }

    //optimal approach: Euclidean algo
    public static int gcdoptimal(){
        int a = num1;
        int b = num2;
        while(a != 0 && b != 0){
            if(a > b){
                a = a - b;
            }
            if(b > a){
                b = b - a;
            }
            if(a == b){
                break;
            }
        }
        return a;
    }

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Input 1: ");
        num1 = in.nextInt();
        System.out.println("Input 2: ");
        num2 = in.nextInt();
        if(num1 < num2){
            min = num1;
        }
        else{
            min = num2;
        }
        System.out.println("Greatest common divisor of the two numbers: " + gcdoptimal());
    }
    
}
