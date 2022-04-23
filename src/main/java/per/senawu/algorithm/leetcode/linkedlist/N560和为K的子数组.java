package per.senawu.algorithm.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sena-wu
 * @date 2022/4/23
 */

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 */
public class N560和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        // 记录前缀和{前缀和值: 出现次数}
        Map<Integer,Integer> memo = new HashMap<Integer,Integer>();
        // 首处理
        memo.put(0,1);
        int count = 0;
        // 记录和为K的子数组个数
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            count += nums[i];
            int need = count - k;
            result += memo.getOrDefault(need, 0);
            memo.put(count, memo.getOrDefault(count, 0) + 1);
        }
        return result;
    }
}
