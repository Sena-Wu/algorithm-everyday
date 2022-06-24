package per.senawu.algorithm.leetcode.dp;

import java.util.HashMap;

/**
 * @author Sena-wu
 * @date 2022/6/23
 */

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 *
 * 链接：https://leetcode.cn/problems/coin-change
 */

/**
 *
 */
public class N322零钱兑换 {
    private HashMap<String, Integer> dpTable = new HashMap<>();
    private int size;
    private int[] coins;
    public int coinChange(int[] coins, int amount) {
        size = coins.length;
        this.coins = coins;
        dp(amount, 0);
        return dpTable.get("-"+amount+"-"+0);

    }
    void dp(int amount, int start){
        if (amount == 0){
            dpTable.put("-"+amount+"-"+start, 0);
            return;
        }
        if (start >= size){
            dpTable.put("-"+amount+"-"+start, -1);
            return;
        }
        if (amount >= coins[start]){
            Integer x = dpTable.get("-"+(amount - coins[start])+"-"+start);
            Integer y = dpTable.get("-"+amount+"-"+(start + 1));
            if (x  == null){
                dp(amount - coins[start], start);
                x = dpTable.get("-"+(amount - coins[start])+"-"+start);
            }
            if (y == null){
                dp(amount, start + 1);
                y = dpTable.get("-"+amount+"-"+(start + 1));
            }
            if (x == -1 && y == -1){
                dpTable.put("-"+amount+"-"+start, -1);
            }else if (x == -1){
                dpTable.put("-"+amount+"-"+start, y);
            }else if (y == -1){
                dpTable.put("-"+amount+"-"+start, x + 1);
            }else{
                dpTable.put("-"+amount+"-"+start, Math.min(x + 1, y));
            }
        }else{
            Integer y = dpTable.get("-"+amount+"-"+(start + 1));
            if (y == null){
                dp(amount, start + 1);
                y = dpTable.get("-"+amount+"-"+(start + 1));
            }
            if (y == -1){
                dpTable.put("-"+amount+"-"+start, -1);
            }else{
                dpTable.put("-"+amount+"-"+start, y);
            }
        }
    }
}
