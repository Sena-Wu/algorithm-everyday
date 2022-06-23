package per.senawu.algorithm.leetcode.dp;

import java.util.HashMap;

/**
 * @author Sena-wu
 * @date 2022/6/23
 */
public class N322零钱兑换 {
    private HashMap<String, Integer> dpTable = new HashMap<>();
    private int size;
    private int[] coins;
    public int coinChange(int[] coins, int amount) {
        size = coins.length;
        this.coins = coins;
        dp(amount, size);
        return dpTable.get("-"+amount+"-"+size);

    }
    void dp(int amount, int start){
        if (amount == 0){
            dpTable.put("-"+amount+"-"+start, 0);
        }
        if (start >= size){
            dpTable.put("-"+amount+"-"+start, -1);
        }
        if (amount >= coins[start]){
            Integer x = -1;
            Integer y = -1;
            if (x = dpTable.get("-"+(amount - coins[start])+"-"+start) == null){
                dp(amount - coins[start], start);
                x = dpTable.get("-"+(amount - coins[start])+"-"+start);
            }
            if (y = dpTable.get("-"+amount+"-"+(start + 1)) == null){
                dp(amount, start + 1);
                y = dpTable.get("-"+amount+"-"+(start + 1));
            }
            if (x == -1 && y == -1){
                dpTable.put("-"+amount+"-"+start, -1);
            }else if (x == -1){
                dpTable.put("-"+amount+"-"+start, y + 1);
            }else if (y == -1){
                dpTable.put("-"+amount+"-"+start, x + 1);
            }else{
                dpTable.put("-"+amount+"-"+start, Math.min(x, y) + 1);
            }
        }
    }
}
