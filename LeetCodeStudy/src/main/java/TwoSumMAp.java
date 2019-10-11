import java.util.HashMap;

/**
 * * Given an array of integers, return indices of the two numbers such that they add up to a
 * specific target.
 *
 * <p>You may assume that each input would have exactly one solution, and you may not use the same
 * element twice.
 *
 * <p>Example:
 *
 * <p>Given nums = [2, 7, 11, 15], target = 9,
 *
 * <p>Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 */
public class TwoSumMAp {

  public static void main(String[] args) {
      int[] numbers = { 2, 7, 11, 15 };
      int target = 9;
      int[] result = new TwoSumMAp().twoSum(numbers, target);
      for (int i = 0; i < result.length; i++) {
          System.out.println(result[i]);
      }


  }

    public int[] twoSum(int[] nums, int target) {
      int[] result = new int[2];
      HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

      for( int i = 0; i < nums.length ; i++ ) {

          if(map.get(target - nums[i]) != null){
              result[0] = map.get(target - nums[i]);
              result[1] = i;

          }else{
              map.put(nums[i],i);
          }
      }

      return  result;

    }
}
