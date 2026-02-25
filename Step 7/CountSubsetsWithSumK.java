
public class CountSubsetsWithSumK{

    private static int recursive(int index, int[] nums, int sum, int k){
        if (index == nums.length){
            if(sum == k){
                return 1;
            }
            return 0;
        }
        int take = recursive(index+1, nums, sum + nums[index], k);
        int notTake = recursive(index+1, nums, sum, k);

        return take+notTake;
    }

    public static void main(String args[]){
        int nums[] = {1, 2, 3, 4};
        int k = 6;
        int result = recursive(0, nums, 0, k);
        System.out.println(result);
    }
}