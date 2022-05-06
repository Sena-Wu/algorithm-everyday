package per.senawu.algorithm.leetcode.arr;

/**
 * @author Sena-wu
 * @date 2022/5/6
 */
public class N528按权重随机选择 {
    int count;
    int[] nums;
    public N528按权重随机选择(int[] w) {
        nums = w;
        count = 0;
        for (int i = 0; i < w.length;i++){
            count += w[i];
            nums[i] = count;
        }
    }

    public int pickIndex() {
        int rand = (int) Math.random() * count;
        return findX(nums, rand);
    }

    // 寻找数组中 >= target 的最小值, 返回其index
    private int findX(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        while(left < right){
            int mid = left + (right - left)/2;
            if (nums[mid] == target){
                return target;
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
