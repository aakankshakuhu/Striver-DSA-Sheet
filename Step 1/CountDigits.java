import java.util.Scanner;
public class CountDigits{
    static int num;

    //my approach: also the brute force approach
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
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Input: ");
        num = in.nextInt();
        int count;
        //optimal approach
        if(num == 0){
            count = 1;
        }
        else{
            count = (int) (Math.log10(num)+1);
        }
        System.out.println("Number of digits: " + count);
        
    }
}
