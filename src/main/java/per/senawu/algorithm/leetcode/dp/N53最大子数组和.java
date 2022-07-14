package per.senawu.algorithm.leetcode.dp;

/**
 * @author Sena-wu
 * @date 2022/7/14
 */

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 * https://leetcode.cn/problems/maximum-subarray/
 */

/**
 * dp: dp[i]表示以i为子区间右边界的最大子区间和
 *   dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
 *
 * 前缀和:
 *  记录当前[0, i]的前缀和 count
 *  记录最小前缀和 min
 *  记录最大子数组和 max
 *  max = max(count, count - min, max)
 */
public class N53最大子数组和 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        // 定义：dp[i] 记录以 nums[i] 为结尾的「最大子数组和」
        int[] dp = new int[n];
        // base case
        // 第一个元素前面没有子数组
        dp[0] = nums[0];
        // 状态转移方程
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        // 得到 nums 的最大子数组
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 前缀和
    public int maxSubArray1(int[] nums) {
        // 最大子区间和
        int max = nums[0];
        // 最小前缀和
        int min = nums[0];
        // 前缀和
        int count = nums[0];
        for (int i = 1; i < nums.length; i++) {
            count += nums[i];
            max = max(count, count - min, max);
            // 更新最小前缀和
            if (count < min) {
                min = count;
            }
        }
        return max;
    }

    private int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), Math.max(a, c));
    }
}
