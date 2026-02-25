public class CheckIfSubsequenceExistsWithSumK {

    private static boolean recursive(int index, int[] nums, int sum, int k){
        if (index == nums.length){
            return sum == k;
        }
        boolean take = recursive(index+1, nums, sum + nums[index], k);
        boolean notTake = recursive(index+1, nums, sum, k);

        return take || notTake;
    }

    public static void main(String args[]){
        int nums[] = {1, 2, 3, 4};
        int k = 9;
        boolean result = recursive(0, nums, 0, k);
        System.out.println(result);
    }
}
