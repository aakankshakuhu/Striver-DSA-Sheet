public class FindMissing {
    
    public static int bruteforce(int arr[], int n, int N){
        for(int i = 1; i <= N; i++){
            int flag = 0;
            for(int j = 0; j < n-1; j++){
                if(arr[j] == i){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                return i;
            }
        }
        return -1;
    }

    public static int hashing(int arr[], int n, int N){
        int hash[] = new int[n+1];
        for(int i = 0; i < n-1; i++){
            hash[arr[i]]++;
        }

        for(int i = 1; i <= N; i++){
            if(hash[i] == 0){
                return i;
            }
        }
        return -1;
    }

    public static int summation(int arr[], int n, int N){
        int sumoffirstN = (N*(N+1))/2;
        int sumofarray = 0;
        for(int i = 0; i < n; i++){
            sumofarray += arr[i];
        }
        return (sumoffirstN - sumofarray);
    }

    public static int xormethod(int arr[], int n, int N){
        int xor1 = 0, xor2 = 0;
        for (int i = 1; i <= N; i++) {
            xor1 = xor1 ^ i;
        }
        for(int i = 0; i < n; i++){
            xor2 = xor2 ^ arr[i];
        }
        return (xor1 ^ xor2);
    }

    public static void main(String args[]){
        int arr[] = {1, 3, 4, 5, 6};
        int N = 6;
        int n = arr.length;
        System.out.println("Missing no: " + xormethod(arr, n, N));
    }
}
