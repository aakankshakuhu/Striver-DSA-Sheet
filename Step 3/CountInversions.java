public class CountInversions {

    public static int bruteforce(int nums[], int n){
        int count = 0;
        for(int i = 0; i < n; i++){
            int a  = nums[i];
            for(int j = i+1; j < n; j++){
                if(nums[j] < a){
                    count++;
                }
            }
        }
        return count;
    }

    public static int conquer(int arr[], int startIdx, int mid, int endIdx){
        int merged[] = new int[endIdx - startIdx + 1];

        int left = startIdx;
        int right = mid + 1; 
        int x = 0;
        int cnt = 0;

        while(left <= mid && right <= endIdx){
            if(arr[left] < arr[right]){
                merged[x++] = arr[left++]; 
            }
            //right is smaller
            else{
                cnt += (mid - left + 1);
                merged[x++] = arr[right++];
            }
        }

        //if elements still left
        while(left <= mid){
            merged[x++] = arr[left++];
        }
        while(right <= endIdx){
            merged[x++] = arr[right++];
        }

        //copying elem from merged array into original array
        for(int i = 0, j = startIdx; i < merged.length; i++, j++){
            arr[j] = merged[i];
        }

        return cnt;

    }

    public static int divide(int arr[], int startIdx, int endIdx){
        int cnt = 0;
        if(startIdx >= endIdx){
            return cnt;
        }
        int mid = startIdx + (endIdx-startIdx)/2;
        cnt += divide(arr, startIdx, mid);
        cnt += divide(arr, mid+1, endIdx);
        cnt  += conquer(arr, startIdx, mid, endIdx);
        return cnt;
    }

    public static void main(String args[]){
        int nums[] = {5,3,2,1,4};
        int n = nums.length;
        System.out.println("No. of inversions: " + divide(nums, 0, n-1));
    }


}
