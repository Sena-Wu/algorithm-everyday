package per.senawu.algorithm.leetcode.binarytree;

/**
 * @author Sena-wu
 * @date 2022/4/17
 */

/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * https://leetcode-cn.com/problems/sort-an-array/
 */

public class N912数组排序 {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    // 快排
    // 先对一个元素进行排序，确定其在排序后数组中的最终位置
    // 递归的对左右剩余元素进行排序
    public void quickSort(int[] nums, int low, int hight){
        if (low < hight){
            int p = partition(nums, low, hight);
            quickSort(nums, low, p-1);
            quickSort(nums, p+1, hight);
        }
    }

    // 升序
    // 确定一个元素的在排序后数组中的位置
    private int partition(int[] nums, int low, int hight){
        int p = nums[low];
        while(low < hight){
            while(low < hight && nums[hight] >= p){hight--;}
            nums[low] = nums[hight];
            while(low < hight && nums[low] <= p){low++;}
            nums[hight] = nums[low];
        }
        nums[low] = p;
        return low;
    }

}
