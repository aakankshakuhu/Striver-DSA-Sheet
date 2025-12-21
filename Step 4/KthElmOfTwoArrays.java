public class KthElmOfTwoArrays {

    public static int myapproach(int arr1[], int arr2[], int k){
        if(arr1.length > arr2.length)   return myapproach(arr2, arr1, k);

        int n1 = arr1.length;
        int n2 = arr2.length;

        int left = k;
        int low = Math.max(k-n2, 0), high = Math.min(k, n1);

        while(low <= high){
            int mid1 = (low + high)/2;
            int mid2 = left - mid1;
            
            int l1 = (mid1 > 0) ? arr1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? arr2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 <n1) ? arr1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? arr2[mid2] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }
            else if (l1 > r2) {
                high = mid1 - 1;
            }
            else{
                low = mid1 + 1;
            }
        }
        return -1;
    }
    
    public static void main(String args[]){
        int arr1[] = {2, 3, 6, 7, 9};
        int arr2[] = {1, 4, 8, 10};
        int k = 5;
        System.out.println("Kth element of two sorted arrays: " + myapproach(arr1, arr2, k));

    }
}
