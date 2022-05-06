package per.senawu.algorithm.leetcode.arr;

/**
 * @author Sena-wu
 * @date 2022/5/6
 */

/**
 * 给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分割成 m 个非空的连续子数组。
 * 设计一个算法使得这 m 个子数组各自和的最大值最小。
 *
 * https://leetcode-cn.com/problems/split-array-largest-sum/
 */

/**
 * 1、确定最小最大值的范围
 * 2、二分搜索确定最小最大值
 * 此题与1011题解法完全一致
 */
public class N410分割数组的最大值 {
    public int splitArray(int[] nums, int m) {
        // 1 <= days <= weights.length <= 5 * 104
        int[] maxandsum = getMaxAndSum(nums);
        // 分割后的数组最少也包含一个值
        int low = maxandsum[0];
        // 最多全部包含
        int high = maxandsum[1];
        while(low < high){
            int mid = low + (high - low) / 2;
            int split = maxAt(nums, mid);
            if (split > m){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return high;
    }

    // 子数组最大值不超过max时 最少可以分割出多少个子数组
    int maxAt(int[] nums, int max){
        int split = 1;
        int once = 0;
        for (int i = 0; i < nums.length;i++){
            once += nums[i];
            if (once > max){
                split++;
                i--;
                once = 0;
            }
        }
        return split;
    }

    int[] getMaxAndSum(int[] nums){
        int max = nums[0];
        int count = nums[0];
        for (int i = 1; i < nums.length; i++){
            max = max > nums[i] ? max : nums[i];
            count += nums[i];
        }
        return new int[]{max, count};
    }

}
