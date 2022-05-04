package per.senawu.algorithm.leetcode.arr;

/**
 * @author Sena-wu
 * @date 2022/5/4
 */

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 链接：https://leetcode-cn.com/problems/binary-search
 */

/**
 * 二分查找：
 *  1、二分查找数组中值为target的元素的下标
 *  2、二分查找数组中第一个值为target的元素的下标    (34题)
 *  3、二分查找数组中最后一个值为target的元素的下标  (34题)
 */
public class N704二分查找 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] == target){
                return mid;
            }

            if (nums[mid] > target){
                right = mid-1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }
        }
        return -1;
    }
}
