import java.util.ArrayList;
import java.util.List;

public class SpiralTraversalofMatrix {

    public static List<Integer> optimalapproach(int arr[][], int n) {

        List<Integer> ans = new ArrayList<>();
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right
            for (int i = left; i <= right; i++) {
                ans.add(arr[top][i]);
            }
            top++;

            // Traverse from top to bottom
            for (int i = top; i <= bottom; i++) {
                ans.add(arr[i][right]);
            }
            right--;

            // Traverse from right to left (only if top <= bottom)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(arr[bottom][i]);
                }
                bottom--;
            }

            // Traverse from bottom to top (only if left <= right)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(arr[i][left]);
                }
                left++;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        int arr[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int n = arr.length;
        System.out.println(optimalapproach(arr, n));

    }
}
