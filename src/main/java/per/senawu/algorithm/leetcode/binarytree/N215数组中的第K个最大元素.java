package per.senawu.algorithm.leetcode.binarytree;

/**
 * @author Sena-wu
 * @date 2022/4/17
 */

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */

/**
 * 利用快速排序中partition方法计算出某一元素的最终位置可以判断第K个最大元素是在此元素的左侧还是右侧
 * 只需将第K个最大元素所在的区域递归的调用partition，最终找到第K个最大元素
 */
public class N215数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length -1, k-1);
        return nums[k-1];
    }

    public void quickSort(int[] nums,int low, int high, int k){
        if (low <= high){
            int p = partition(nums, low, high);
            if (p == k){
                return;
            }else if(p > k){
                quickSort(nums, low, p-1, k);
            }else{
                quickSort(nums, p+1, high, k);
            }
        }
    }

    /** 降序
     */
    private int partition(int[] nums, int low, int high){
        if (low == high){
            return low;
        }
        int p = nums[low];
        while(low < high){
            while(low < high && nums[high] <= p){high--;}
            nums[low] = nums[high];
            while(low < high && nums[low] >= p){low++;}
            nums[high] = nums[low];
        }
        nums[low] = p;
        return low;
    }
}
