public class NthRootofNumber {

    public static int myapproach(int m, int n){
        int low = 1, high = m;
        while(low <= high){
            int mid = low + (high-low)/2;
            int ans = 1;
            for(int i = 1; i <= n; i++){
                ans *= mid;
                if(ans > m)     break;
            }
            if(ans == m){
                return mid;
            }
            else if (ans > m){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
    
    public static void main(String args[]){
        int m = 256;
        int n = 4;
        System.out.println("The Nth root of M is: " + myapproach(m, n));
    }
}
