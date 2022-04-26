package per.senawu.algorithm.leetcode.arr;

/**
 * @author Sena-wu
 * @date 2022/4/26
 */

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 链接：https://leetcode-cn.com/problems/remove-element
 */
public class N27移除元素 {
    public int removeElement(int[] nums, int val) {
        if (nums.length <= 1){
            return nums.length == 1 && nums[0] == val ? 0 : nums.length;
        }
        int slow = 0;
        int quick = 0;
        while (quick < nums.length){
            if (nums[quick] == val){
                quick++;
            }else{
                nums[slow] = nums[quick];
                slow++;
                quick++;
            }
        }
        return slow;
    }
}
