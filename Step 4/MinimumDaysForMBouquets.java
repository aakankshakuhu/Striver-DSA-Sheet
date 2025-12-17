public class MinimumDaysForMBouquets {

    public static int myapproach(int arr[], int n, int m, int k){
        int total = m*k;
        int result = -1;
        if (total > n){
            return result;
        }
        int low = minElm(arr, n), high = maxElm(arr, n);
        while(low <= high){
            int mid = low + (high-low)/2;
            if(bloom(arr, n, m, k, mid) == false){
                low = mid+1;
            }
            else{
                result = mid;
                high = mid-1;
            }
        }
        return result;
    }

    public static boolean bloom(int arr[], int n, int m, int k, int mid){
        int cntFlowers = 0, cntBouquet = 0;
        for(int i = 0; i < n; i++){
            if(mid < arr[i]){
                cntFlowers = 0;
            }
            else{
                cntFlowers++;
                if(cntFlowers == k){
                    cntBouquet++;
                    cntFlowers = 0;
                }
            }
        }
        return (cntBouquet >= m);
    }

    public static int minElm(int arr[], int n){
        int min = arr[0];
        for(int i = 1; i < n; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    public static int maxElm(int arr[], int n){
        int max = arr[0];
        for(int i = 1; i < n; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    
    public static void main(String args[]){
        int arr[] = {7, 7, 7, 7, 13, 11, 12, 7};
        int n = arr.length;
        int m = 2, k = 3;
        System.out.println("Minimum number of days required to make m bouquets: " + myapproach(arr, n, m, k));
    }
}

