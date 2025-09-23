import java.util.Scanner;
public class PalindromeString {

    public static boolean myapproach(String str){
        int p = str.length();
        for(int i = 0; i <= p/2; i++){
            if(str.charAt(i) != str.charAt(p-i-1)){
                return false;
            }
        }
        return true;
    }

    public static boolean recursiveapproach(String str, int i){
        int p = str.length();
        if(i > p/2){
            return true;
        }
        if(str.charAt(i) != str.charAt(p-i-1)){
            return false;
        }
        else{
            return recursiveapproach(str, i+1);
        }
    }

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = in.next();
        System.out.println(recursiveapproach(str, 0));
    }
}

