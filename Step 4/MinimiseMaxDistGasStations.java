import java.util.PriorityQueue;

class Pair {
    double distance;
    int index;

    Pair(double distance, int index) {
        this.distance = distance;
        this.index = index;
    }
}

public class MinimiseMaxDistGasStations {

    public double priorityqueueapproach(int arr[], int n, int k){
        int sectors[] = new int[n-1];

        //priority-queue to store the largest segment first
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b.distance, a.distance)
        );

        //add initial segments
        for(int i = 0; i < n-1; i++){
            pq.add(new Pair(arr[i+1] - arr[i], i));
        }

        //place k additional gas stations
        for(int gasStations = 1; gasStations <= k; gasStations++){
            Pair top = pq.poll();
            int idx = top.index;
            sectors[idx]++;

            double totalDist = arr[idx+1] - arr[idx];
            double newDist = totalDist / (sectors[idx]+1.0);
            pq.add(new Pair(newDist, idx));
        }

        return pq.peek().distance;
    }

    public static int noOfGasStations(int arr[], int n, double dist) {
        int count = 0;
        for(int i = 1; i < n; i++){
            int numberInBetween  = (int) ((arr[i]-arr[i-1]) / dist);
            if((arr[i]-arr[i-1] == (dist*numberInBetween))){
                numberInBetween--;
            }
            count += numberInBetween;
        }
        return count;
    }

    public static double binarysearch(int arr[], int n, int k){
        double low = 0, high = 0;

        for(int i = 0; i < n-1; i++) {
            high = Math.max(high, arr[i+1]-arr[i]);
        }

        double diff = 1e-6;
        while(high-low > diff){
            double mid = (low + high)/2.0;
            int count = noOfGasStations(arr, n, mid);

            if(count > k){
                low = mid;
            }
            else{
                high = mid;
            }
        }
        return high;

    }

    
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
        System.out.println("Minimum maximum distance between two gas stations is: " + cls.binarysearch(arr, n, k));
    }
}
