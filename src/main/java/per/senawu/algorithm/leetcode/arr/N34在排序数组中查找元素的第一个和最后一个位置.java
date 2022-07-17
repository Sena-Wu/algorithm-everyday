package per.senawu.algorithm.leetcode.arr;

/**
 * @author Sena-wu
 * @date 2022/5/4
 */

/**
 *给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 */

/**
 * 二分查找：
 *  1、二分查找数组中值为target的元素的下标
 *  2、二分查找数组中第一个值为target的元素的下标
 *  3、二分查找数组中最后一个值为target的元素的下标
 */
public class N34在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int left = 0;
        int right = nums.length -1;
        int mid = 0;

        // 数组中值为target的元素的下标
        while(left <= right){
            mid = left + (right - left)/2;
            if (nums[mid] == target){
                break;
            }
            if(nums[mid] > target){
                right = mid -1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }
        }
        // nums长度为0 或者 nums中无值为target的元素
        if (nums.length == 0 || nums[mid] != target){
            return result;
        }

        // 确定左边界: [0, mid]范围内第一个值为target的index
        // nums[mid] == target
        left = 0;
        right = mid;
        while(left <= right){
            int mid_ = left + (right - left)/2;
            if (nums[mid_] == target){
                right = mid_ - 1;
            }
            if(nums[mid_] > target){
                right = mid_ - 1;
            }else if(nums[mid_] < target){
                left = mid_ + 1;
            }
        }
        result[0] = right + 1;

        // 确定左边界: [mid, nums.length -1]范围内最后一个值为target的index
        // nums[mid] == target
        left = mid;
        right = nums.length -1;
        while(left <= right){
            int mid_ = left + (right - left)/2;
            if (nums[mid_] == target){
                left = mid_ + 1;
            }
            if(nums[mid_] > target){
                right = mid_ -1;
            }else if(nums[mid_] < target){
                left = mid_ + 1;
            }
        }
        result[1] = left - 1;

        return result;
    }
}
