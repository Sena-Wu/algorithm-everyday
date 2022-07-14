package per.senawu.algorithm.leetcode.dp;

import java.util.Arrays;
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
 * dp[i] = Math.min(dp[i] , dp[i - coins[j]] + 1)
 * dp 初始化填充值 amount + 1; dp[0] = 0;
 * 1 计算[1, amount]内各个金额最少需要几次
 * 2 遍历coins: if (coins[j] <= target)
 *      3 dp[target] = Math.min(dp[target] , dp[target - coins[j]] + 1)
 *
 * 4 return dp[amount] > amount ? -1 : dp[amount];
 */
public class N322零钱兑换 {

    public int coinChange(int[] coins, int amount) {
        // 最小面额至少为1, 最多也就只可能要 amount 个 1
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        // 计算[1, amount]内各个金额最少需要几次
        for (int i = 1; i <= amount; i ++){
            for (int j = 0; j < coins.length; j ++){
                if (coins[j] <= i){
                    dp[i] = Math.min(dp[i] , dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

//    private HashMap<String, Integer> dpTable = new HashMap<>();
//    private int size;
//    private int[] coins;
//    public int coinChange(int[] coins, int amount) {
//        size = coins.length;
//        this.coins = coins;
//        dp(amount, 0);
//        return dpTable.get("-"+amount+"-"+0);
//    }
//    void dp(int amount, int start){
//        if (amount == 0){
//            dpTable.put("-"+amount+"-"+start, 0);
//            return;
//        }
//        if (start >= size){
//            dpTable.put("-"+amount+"-"+start, -1);
//            return;
//        }
//        if (amount >= coins[start]){
//            Integer x = dpTable.get("-"+(amount - coins[start])+"-"+start);
//            Integer y = dpTable.get("-"+amount+"-"+(start + 1));
//            if (x  == null){
//                dp(amount - coins[start], start);
//                x = dpTable.get("-"+(amount - coins[start])+"-"+start);
//            }
//            if (y == null){
//                dp(amount, start + 1);
//                y = dpTable.get("-"+amount+"-"+(start + 1));
//            }
//            if (x == -1 && y == -1){
//                dpTable.put("-"+amount+"-"+start, -1);
//            }else if (x == -1){
//                dpTable.put("-"+amount+"-"+start, y);
//            }else if (y == -1){
//                dpTable.put("-"+amount+"-"+start, x + 1);
//            }else{
//                dpTable.put("-"+amount+"-"+start, Math.min(x + 1, y));
//            }
//        }else{
//            Integer y = dpTable.get("-"+amount+"-"+(start + 1));
//            if (y == null){
//                dp(amount, start + 1);
//                y = dpTable.get("-"+amount+"-"+(start + 1));
//            }
//            if (y == -1){
//                dpTable.put("-"+amount+"-"+start, -1);
//            }else{
//                dpTable.put("-"+amount+"-"+start, y);
//            }
//        }
//    }
}
