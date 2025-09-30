public class StockBuyAndSell {
    
    public static int bruteforceapproach(int arr[], int n) {
        int maxProfit = 0;
        for(int i = 0; i < n; i++) {
            int buy = arr[i];
            for(int j = i+1; j < n; j++) {
                int diff = arr[j] - buy;
                maxProfit = Math.max(diff, maxProfit);
            }
        }
        return maxProfit;
    }
    
    public static int optimalapproach(int arr[], int n) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, arr[i]);
            maxProfit = Math.max(maxProfit, (arr[i]-minPrice));
        }
        return maxProfit;
    }

    public static void main(String args[]) {
        int arr[] = {7,1,5,3,6,4};
        int n = arr.length;
        System.out.println("Maximum Profit: " + optimalapproach(arr, n));
    }
}
