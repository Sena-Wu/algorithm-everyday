package per.senawu.algorithm.leetcode.arr;

/**
 * @author Sena-wu
 * @date 2022/7/17
 */

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * https://leetcode.cn/problems/trapping-rain-water/
 */

/**
 * 双指针控制水位: 低于该水位的填满; left = 0 ; right = length - 1;
 *  从双头指针中低水位的一侧 遍历-接雨水, 直至碰到更高的水位更新指针, 重复此过程直至全部遍历完
 */
public class N42接雨水 {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        // 工作指针
        int work = left + 1;
        // 接的雨水
        int count = 0;
        while(left < right &&  left < work && work < right){
            // 双指针哪头水位低从哪头开始
            if (height[left] < height[right]){
                // 左侧水位低, 工作指针从左侧开始
                work = left + 1;
                // 低于该水位 接雨水填满
                while (height[work] < height[left]){
                    count += height[left] - height[work];
                    work++;
                }
                // 碰见更高水位值, 更新左侧水位值
                left = work;
                // 只是为了满足left < work && work < right的判断; 下一轮循环会被重新赋值
                work++;
            }else{
                work = right - 1;
                while (height[work] < height[right]){
                    count += height[right] - height[work];
                    work--;
                }
                right = work;
                // 同上
                work--;
            }
        }
        return count;
    }
}
