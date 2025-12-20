public class MinimiseMaxDistGasStations {

    public static double bruteforce(int arr[], int n, int k){
        int sectors[] = new int[n-1];
        for(int gasStation = 1; gasStation <= k; gasStation++){
            double maxSection = -1;
            int maxInd = -1;

            for(int i = 0; i < n-1; i++){
                double diff = arr[i+1] - arr[i];
                double sectionLength = diff / (sectors[i] + 1.0);

                if(sectionLength > maxSection){
                    maxSection = sectionLength;
                    maxInd = i;
                }
            }
            sectors[maxInd]++;
        }

        double maxAns = -1;
        for(int i = 0; i < n-1; i++){
            double diff = arr[i+1] - arr[i];
            double sectionLength = diff / (sectors[i] + 1.0);
            maxAns = Math.max(maxAns, sectionLength);
        }
        return maxAns;
    }
    
    public static void main(String args[]){
        int arr[] = {1, 2, 3, 4, 5};
        int n = arr.length;
        int k = 4;
        MinimiseMaxDistGasStations cls = new MinimiseMaxDistGasStations();
        System.out.println("Minimum maximum distance between two gas stations is: " + cls.bruteforce(arr, n, k));
    }
}
