import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class PrintDivisors {
    static int num;

    //brute force approach
    public static void divisorsbrute(){
        ArrayList<Integer> div = new ArrayList<>();
        for(int i = 1; i <= num; i++){
            if(num % i == 0){
                div.add(i);
            }
        }
        System.out.println("List of divisors: " + div);
    }

    //optimal approach
    public static void divisorsoptimal(){
        ArrayList<Integer> div = new ArrayList<>();
        for(int i = 1; i*i <= num; i++){
            if(num % i == 0){
                div.add(i);
                if(num/i != i){
                    div.add(num/i);
                }
            }
        }
        Collections.sort(div);
        System.out.println("List of divisors: " + div);
    }


    public static void main(String args[]){
        Scanner in =new Scanner(System.in);
        System.out.println("Input: ");
        num = in.nextInt();
        divisorsoptimal();
    }
}
