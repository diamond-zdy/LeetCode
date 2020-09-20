import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums int整型一维数组 给定一个整数数组 nums
     * @return int整型
     */
    public int maxSubArray (int[] nums) {
        // write code here
        //求最大的连续子序列的和
        int[] arr = new int[nums.length+1];
        arr[0] = nums[0];
        for (int i = 1;i < nums.length;i++){
            arr[i] = Math.max(nums[i],arr[i-1]+nums[i]);
        }
        int max = arr[0];
        for (int i = 0;i < nums.length+1;i++){
            if (max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
    public int thirdMax (int[] nums) {
        // write code here
        //求第三大的数
        int k = 2;
        Arrays.sort(nums);
        if (nums.length == 0 || nums.length<= 3){
            return nums[nums.length-1];
        }
        int max = nums[nums.length-1];

        for (int i = nums.length-2;i >= 0;i--){
            if (max > nums[i]){
                max = nums[i];
                k--;
            }
            if (k == 0){
                break;
            }
        }
        if (k == 0){
            return max;
        }else {
            return nums[nums.length-1];
        }
    }
}