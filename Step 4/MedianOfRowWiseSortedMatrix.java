public class MedianOfRowWiseSortedMatrix {

    public static int myapproach(int nums[][], int n, int m){
        int low = nums[0][0];
        int high = nums[0][m-1];

        for(int i = 0; i < n; i++){
            low = Math.min(low, nums[i][0]);
            high = Math.max(high, nums[i][m-1]);
        }

        while (low < high){
            int mid = low + (high-low)/2;
            int count = 0;

            for(int i = 0; i < n; i++){
                count += countLessEqual(nums[i], mid);
            }

            if(count < (n*m + 1)/2){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }

    public static int countLessEqual(int[] row, int mid){
        int low = 0, high = row.length;
        while(low < high){
            int m = low + (high-low)/2;
            if(row[m] <= mid) low = m+1;
            else high = m;
        }
        return low;
    }
    
    public static void main(String args[]){
        int nums[][] = {
            {1, 3, 5},
            {2, 6, 9},
            {3, 6, 9}
        };
        int n = nums.length;
        int m = nums[0].length;
        System.out.println("Median of given Row-wise sorted matrix: " + myapproach(nums, n, m));
    }
}
