import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MergeOverlappingArrays {

    public static List<List<Integer>> bruteforce(int[][] intervals){

        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        List<List<Integer>> result = new ArrayList<>();

        int n = intervals.length;
        int i = 0;

        while(i < n) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            int j = i+1;

            while(j < n && intervals[j][0] <= end) {
                end = Math.max(end, intervals[j][1]);
                j++;
            }

            result.add(Arrays.asList(start, end));
            i = j;
        }
        return result;

    }

    public static List<List<Integer>> optimal(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> result = new ArrayList<>();

        for(int[] interval: intervals) {
            if(result.isEmpty() || result.get(result.size()-1).get(1) < interval[0]) {
                result.add(Arrays.asList(interval[0], interval[1]));
            }
            else {
                int last = result.size() - 1;
                int maxEnd = Math.max(result.get(last).get(1), interval[1]);
                result.get(last).set(1, maxEnd);
            }
        }
        return result;
    }

    public static void main(String args[]){
        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
        System.out.println(optimal(intervals));
    }
}
