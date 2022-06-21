package per.senawu.algorithm.leetcode.linkedlist;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Sena-wu
 * @date 2022/6/20
 */

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 *
 * 链接：https://leetcode.cn/problems/sliding-window-maximum
 */

/**
 * 维护一个单调队列：
 *  新加入元素：对位元素小于新元素的全部弹出, 元素下标入队
 *  控制窗口[i-k+1, i]; 队首元素的下标<=i-k,则弹出队首元素
 *  队首元素为窗口[i-k+1, i]的最大值;
 */
public class N239滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++){

            while(!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]){queue.pollLast();}
            // 下标放入队列
            queue.offerLast(i);
            // 队首下标是否在窗口内，不在窗口内删除;i - k是窗口的左边界
            if (i >= k){
                while (!queue.isEmpty() && i - k >= queue.peekFirst()){queue.pollFirst();}
            }
            if (i >= k - 1){
                res[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}
