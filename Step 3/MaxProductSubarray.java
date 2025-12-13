public class MaxProductSubarray {
    
    public static int optimal(int arr[], int n){
        int prefix = 1, suffix = 1;
        int max_prod = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(prefix == 0){
                prefix = 1;
            }
            else if(suffix == 0){
                suffix = 1;
            }
            prefix = prefix * arr[i];
            suffix = suffix * arr[n-i-1];
            max_prod = Math.max(max_prod, (Math.max(prefix, suffix)));
        }
        return max_prod;
    }
    

    public static void main(String args[]){
        int arr[] = {1,2,-3,0,-4,-5};
        int n = arr.length;
        System.out.println("Maximun Product of Subarray: " + optimal(arr, n));
    }
}
