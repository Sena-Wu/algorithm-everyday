package per.senawu.algorithm.leetcode.arr;

/**
 * @author Sena-wu
 * @date 2022/5/6
 */

/**
 * 给你一个 下标从 0 开始 的正整数数组 w ，其中 w[i] 代表第 i 个下标的权重。
 * 请你实现一个函数 pickIndex ，它可以 随机地 从范围 [0, w.length - 1] 内（含 0 和 w.length - 1）选出并返回一个下标。选取下标 i 的 概率 为 w[i] / sum(w) 。
 *
 * 链接：https://leetcode-cn.com/problems/random-pick-with-weight
 */

/**
 * 前缀和 and 二分查找
 */
public class N528按权重随机选择 {
    int count = 0;
    int[] nums;
    public N528按权重随机选择(int[] w) {
        nums = w;
        // 计算前缀和数组
        for (int i = 0; i < w.length;i++){
            count += w[i];
            nums[i] = count;
        }
    }

    public int pickIndex() {
        // 取[1, count]内一个随机数
        // Math.random() -> [0, 1);  Math.random() * count -> [0, count)
        // (Math.random() * count) 不加括号的效果 变成((int)  Math.random()) * count
        int rand = (int) (Math.random() * count) + 1;
        return findX(nums, rand);
    }

    // 寻找数组中 >= target 的最小值, 返回其index
    private int findX(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        while(left < right){
            int mid = left + (right - left)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] > target){
                right = mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }
        }
        return right;
    }
}
