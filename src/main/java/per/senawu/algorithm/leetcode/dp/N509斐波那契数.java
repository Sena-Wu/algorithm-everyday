package per.senawu.algorithm.leetcode.dp;

/**
 * @author Sena-wu
 * @date 2022/6/30
 */

/**
 * 斐波那契数（通常用F(n) 表示）形成的序列称为 斐波那契数列 。该数列由0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1)= 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定n ，请计算 F(n) 。
 *
 * 链接：https://leetcode.cn/problems/fibonacci-number
 */

/**
 * 1、递归
 * 2、动态规划(√) + 优化空间复杂度
 */
public class N509斐波那契数 {
    public int fib(int n) {
        // f(n) = f(n- 1) + f(n-2)
        // x: f(n-2) y: f(n-1)
        if (n < 2){
            return n;
        }
        // 滚动更新代替使用dp[n] ; 因为f(n)只与f(n- 1),f(n-2)相关
        int x = 0;
        int y = 1;
        int result = 0;
        for (int i = 2; i <= n; i++){
            result = x + y;
            x = y;
            y = result;
        }
        return result;
    }
}
