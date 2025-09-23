import java.util.Scanner;
public class Recursion {

    public static void func(int i, int n){
        if (i > n){
            return;
        }
        System.out.println("Aakanksha");

        func(++i, n);
    }

    public static void printNumbers(int i, int n){
        if (i > n){
            return;
        }
        System.out.println(i);

        printNumbers(++i, n);
    }

    public static void printNumbersReverse(int i, int n){
        if (n < i){
            return;
        }
        System.out.println(n);

        printNumbersReverse(i, n-1);        
    }
    //parameterized approach
    public static int sumOfFirstNnumbers(int n, int sum){
       if(n == 0){
            return sum;
       }
       sum = sum + n;
       return sumOfFirstNnumbers(--n, sum);
    }

    //functional approach
    public static int sumOfFirstNnumbersFunctional(int n){
        if(n == 0){
            return 0;
        }

        return n + sumOfFirstNnumbersFunctional(--n);
    }

    public static int Factorial(int n){
        if(n == 1 || n == 0){
            return 1;
        }

        return n * Factorial(--n);
    }

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        printNumbers(0, 5);
        
    }
    
}
