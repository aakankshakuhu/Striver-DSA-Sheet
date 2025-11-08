public class MergeTwoSortedArrays {

    public static void myapproach(int arr1[], int arr2[], int m, int n){
        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while(i >= 0 && j >= 0){
            if(arr1[i] > arr2[j]) {
                arr1[k--] = arr1[i--];
            }
            else {
                arr1[k--] = arr2[j--];
            }
        }

        while(j >= 0) {
            arr1[k--] = arr2[j--];
        }
    }
    
    public static void main(String args[]){
        int arr1[] = {0, 2, 7, 8, 0, 0, 0};
        int arr2[] = {-7, -3, -1};
        int m = 4, n = 3;
        myapproach(arr1, arr2, m, n);
        for(int a:arr1) {
            System.out.print(a + " ");
        }

    }
}
