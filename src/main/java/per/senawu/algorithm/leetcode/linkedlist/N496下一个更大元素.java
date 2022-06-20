package per.senawu.algorithm.leetcode.linkedlist;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Sena-wu
 * @date 2022/6/20
 */

/**
 *nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 *
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 *
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 *
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 *
 * 链接：https://leetcode.cn/problems/next-greater-element-i
 */

/**
 * 计算数组中元素 x 右侧第一个 比 x 大的元素
 * 输入一个数组 nums = [2,1,2,4,3]，你返回数组 [4,2,4,-1,-1]
 *  从后往前遍历数组，使用单调栈stack保存更大元素,res数组保存结果
 *      1、遍历到该元素x时把stack中小于x的元素pop出来
 *      2、stack不为空则peak stack栈顶元素保存至res, 否则保存-1至res
 */
public class N496下一个更大元素 {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] greater = nextGreaterElement(nums2);
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++){
            res[i] = greater[map.get(nums1[i])];
        }
        return res;
    }

    private int[] nextGreaterElement(int[] nums){
        int[] res = new int[nums.length];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--){
            map.put(nums[i], i);
            while(!stack.isEmpty() && stack.peek() <= nums[i]){stack.pop();}
            if(stack.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = stack.peek();
            }
            stack.push(nums[i]);
        }
        return res;
    }
}
