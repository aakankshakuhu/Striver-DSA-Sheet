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

    public static double betterapproach(int arr1[], int arr2[], int n, int m){
        int sizeOfSortedArray = n+m;
        int idx1 = sizeOfSortedArray/2, idx2 = idx1-1;
        int elm1 = -1, elm2 = -1;
        int i = 0, j = 0, cnt = 0;

        while(i < n && j < m){
            int val;
            if (arr1[i] < arr2[j]){
                val = arr1[i++];
            }else{
                val = arr2[j++];
            }

            if(cnt == idx1) elm1 = val;
            if(cnt == idx2) elm2 = val;

            cnt++;
        }

        while(i < n){
            if(cnt == idx1) elm1 = arr1[i];
            if(cnt == idx2) elm2 = arr1[i];
            i++;
            cnt++;
        }
        while(j < m){
            if(cnt == idx1) elm1 = arr2[j];
            if(cnt == idx2) elm2 = arr2[j];
            j++;
            cnt++;
        }

        if(sizeOfSortedArray % 2 == 1){
            return elm2;
        }
        else{
            return (elm1+elm2)/2.0;
        }
    }

    public static double binarysearch(int arr1[], int arr2[]){

        //ensure that the binary search is applied on the smaller array
        if (arr1.length > arr2.length)  return binarysearch(arr2, arr1);

        int n1 = arr1.length, n2 = arr2.length;
        int low = 0, high = n1;

        while(low <= high) {
            int cut1 = (low+high)/2;
            int cut2 = (n1+n2+1)/2 - cut1;

            int l1;
            if(cut1 == 0){
                l1 = Integer.MIN_VALUE;
            }
            else{
                l1 = arr1[cut1 - 1];
            }

            int l2;
            if(cut2 == 0){
                l2 = Integer.MIN_VALUE;
            }
            else{
                l2 = arr2[cut2 - 1];
            }

            int r1;
            if(cut1 == n1){
                r1 = Integer.MAX_VALUE;
            }
            else{
                r1 = arr1[cut1];
            }

            int r2;
            if(cut2 == n2){
                r2 = Integer.MAX_VALUE;
            }
            else{
                r2 = arr2[cut2];
            }

            if(l1 <= r2 && l2 <= r1){
                if((n1+n2) % 2 == 0){
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;
                }
                else{
                    return(Math.max(l1, l2));
                }
            }

            else if(l1 > r2){
                high = cut1 - 1;
            }
            else{
                low = cut1 + 1;
            }
        }
        return 0.0;
    }
    
    public static void main(String args[]){
        int arr1[] = {2, 4, 6};
        int arr2[] = {1, 3, 5, 7};
        int n = arr1.length;
        int m = arr2.length;
        System.out.println("Median of the two sorted arrays: " + binarysearch(arr1, arr2));
    }
}
