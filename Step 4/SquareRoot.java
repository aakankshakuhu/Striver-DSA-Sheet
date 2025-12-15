public class SquareRoot {

    public static int linearsearch(int num){
        int ans = 0;
        for(int i = 1; i < num/2; i++){
            if(i*i <= num){
                ans = i;
            }
        }
        return ans;
    }

    public static int binarysearch(int num){
        int ans = 0;
        int low = 1, high = num/2;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(mid*mid <= num){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
    
    public static void main(String args[]){
        int num = 60;
        System.out.println("Square root: " + binarysearch(num));
    }
}
