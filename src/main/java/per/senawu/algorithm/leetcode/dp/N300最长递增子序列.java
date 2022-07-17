package per.senawu.algorithm.leetcode.dp;

/**
 * @author Sena-wu
 * @date 2022/7/1
 */

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 链接：https://leetcode.cn/problems/longest-increasing-subsequence
 */

/**
 * 解法一: 动态规划
 * dp[i] 表示 以nums[i]为递增子序列最后一个值的最长子序列的长度
 *      dp[i] = max( if (nums[i] > nums[j]): dp[i] = dp[j] + 1); condition:i > j
 *      result = max(dp[i])
 *
 * 更优解法 : (扑克牌接龙) 用多个有序列表维护nums中存在的多个递增子序列
 *  遍历nums; 1、nums[i] 可以接到现有的列表中直接加入; 不可以则新建一个新的列表; 可以发现列表的最后一个元素是递增序列
 *      二分查找法判断nums[i] 是否可以加入现有列表(比较个列表的最后一个元素与nums[i]的大小,小于nums[i]可以放入)
 *      多个列表符合nums[i]加入条件则放入最左的列表中(用以保证列表的最后一个元素是递增序列); 也就是二分查找最左元素
 *  result = max( subLists[i].length())
 */
public class N300最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 1;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++){
            dp[i] = 1;
            // 遍历j 获取dp[i]的所有可能取值并给dp[i]赋最大值
            for (int j = i-1; j >= 0; j--){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}
