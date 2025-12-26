import java.util.Arrays;
public class PeakElmIn2dArray {

    public static int[] myapproach(int nums[][], int n, int m){
        int low = 0, high = m-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            int row = maxElmInCol(nums, n, mid);
            
            int left = mid-1 >= 0 ? nums[row][mid-1] : Integer.MIN_VALUE;
            int right = mid+1 < m ? nums[row][mid+1] : Integer.MIN_VALUE;

            if(nums[row][mid] > left && nums[row][mid] > right){
                return new int[]{row, mid};
            }
            else if(left > nums[row][mid]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return new int[]{-1, -1};
    }

    public static int maxElmInCol(int[][] nums, int n, int mid){
        int max = Integer.MIN_VALUE;
        int idx = -1;
        for(int i = 0; i < n; i++){
            if(nums[i][mid] > max){
                max = nums[i][mid];
                idx = i;
            }
        }
        return idx;
    }
    
    public static void main(String args[]){
        int nums[][] = {
            {5, 10, 8}, 
            {4, 25, 7}, 
            {3, 9, 6}
        };
        int n = nums.length;
        int m = nums[0].length;
        System.out.println("Peak Element in the 2d array occurs at: " + Arrays.toString(myapproach(nums, n, m)));
    }
}
