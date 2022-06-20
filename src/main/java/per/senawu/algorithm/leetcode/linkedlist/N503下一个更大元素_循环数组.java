package per.senawu.algorithm.leetcode.linkedlist;

/**
 * @author Sena-wu
 * @date 2022/6/20
 */

import java.util.LinkedList;

/**
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 *
 * 链接：https://leetcode.cn/problems/next-greater-element-ii
 */

/**
 * 拓展数组来模拟循环数组:T[1,2,3,4,3] 拓展为S [1,2,3,4,3,1,2,3,4,3]; 遍历S相当于循环遍历T;
 * 遍历 S 来计算数组T中元素 x 右侧第一个 比 x 大的元素; 逻辑拓展:for(int i = 2 * T.length - 1; i >= 0; i--);
 *  从后往前遍历T数组，使用单调栈stack保存更大元素,res数组保存结果
 *     1、遍历到该元素T[i % nums.length]时把stack中小于x的元素pop出来
 *     2、stack不为空则peak stack栈顶元素保存至res[i % nums.length], 否则保存-1至res[i % nums.length]
 *     3、把 T[i % nums.length] 的下标压入栈顶
 */
public class N503下一个更大元素_循环数组 {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        LinkedList<Integer> stack = new LinkedList<>();
        for(int i = 2 * nums.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && nums[i % nums.length] >= stack.peek()){stack.pop();}
            if (stack.isEmpty()){
                res[i % nums.length] = -1;
            }else{
                res[i % nums.length] = stack.peek();
            }
            stack.push(nums[i % nums.length]);
        }
        return res;
    }
}
