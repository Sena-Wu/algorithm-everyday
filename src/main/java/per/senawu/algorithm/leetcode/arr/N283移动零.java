package per.senawu.algorithm.leetcode.arr;

/**
 * @author Sena-wu
 * @date 2022/4/26
 */

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class N283移动零 {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int quick = 0;
        // 非零元素紧密排靠
        while (quick < nums.length){
            if (nums[quick] == 0){
                quick++;
            }else{
                nums[slow] = nums[quick];
                // 置零 可省去尾处理
                nums[quick] = 0;
                slow++;
                quick++;
            }
        }
        // 尾处理 剩余位置置零
        // while(slow < nums.length){nums[slow++] = 0;}
    }
}
