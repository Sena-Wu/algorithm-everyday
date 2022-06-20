package per.senawu.algorithm.leetcode.linkedlist;

import java.util.LinkedList;

/**
 * @author Sena-wu
 * @date 2022/6/20
 */

/**
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 链接：https://leetcode.cn/problems/daily-temperatures
 */

/**
 * 反向遍历数组, 维护一个单调栈存储更大元素
 * 从后往前遍历数组，使用单调栈stack保存更大元素的下标,res数组保存结果
 *      1、遍历到该元素x时把stack中小于x的元素pop出来
 *      2、stack不为空则peak stack栈顶元素保存至res, 否则保存-1至res
 *      3、把 x 的下标压入栈顶
 */
public class N739下一个更大元素_每日温度 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = temperatures.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]){stack.pop();}
            if (stack.isEmpty()){
                res[i] = 0;
            }else{
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return res;
    }
}
