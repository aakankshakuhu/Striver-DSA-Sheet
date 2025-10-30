public class SearchInsertPosition{

    public static int binarysearch(int nums[], int n, int x) {
        int low = 0, high = n-1, ans = n;
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] >= x){
                ans = mid;
                high = mid-1;

            }
            else {
                low = mid+1;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        int nums[] = {1,2,4,5};
        int n = nums.length;
        int x = 6;
        System.out.println("Required index: " + binarysearch(nums, n, x));
    }
}
