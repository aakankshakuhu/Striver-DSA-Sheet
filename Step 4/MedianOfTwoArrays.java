public class MedianOfTwoArrays {

    public static double bruteforce(int arr1[], int arr2[], int n, int m){
        int merged[] = new int[n+m];
        int i = 0, j = 0, k = 0;

        while(i < n && j < m){
            if(arr1[i] < arr2[j]){
                merged[k++] = arr1[i++];
            }
            else{
                merged[k++] = arr2[j++];
            }
        }

        while(i < n){
            merged[k++] = arr1[i++];
        }
        while(j < m){
            merged[k++] = arr2[j++];
        }
        int o = n+m;

        if(o%2 != 0){
            return merged[o/2];
        }
        else{
            return (merged[(o / 2) - 1] + merged[o / 2]) / 2.0;
        }
    }
    
    public static void main(String args[]){
        int arr1[] = {2, 4, 6};
        int arr2[] = {1, 3, 5, 7};
        int n = arr1.length;
        int m = arr2.length;
        System.out.println("Median of the two sorted arrays: " + bruteforce(arr1, arr2, n, m));
    }
}
