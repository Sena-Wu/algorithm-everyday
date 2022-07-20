package per.senawu.algorithm.leetcode.arr;

/**
 * @author Sena-wu
 * @date 2022/3/23
 */

/**
 * 给定一个长度为 n 的整数数组[]height。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量
 *
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 */

/**
 * 双指针: 数值低的指针移动, 直至遇到比另一边界高的, 换向, 从另一指针开始遍历
 */
public class N11盛最多水的容器 {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            if (height[left] < height[right]){
                while(height[left] <= height[right] && left < right){
                    max = Math.max(max, (right - left) * height[left]);
                    left++;
                }
            }else{
                while(height[right] <= height[left] && left < right){
                    max = Math.max(max, (right - left) * height[right]);
                    right--;
                }
            }
        }
        return max;

    }
}
