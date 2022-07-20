package per.senawu.algorithm.leetcode.dp;

/**
 * @author Sena-wu
 * @date 2022/7/20
 */

/**
 * 给定两个字符串s1 和 s2，返回 使两个字符串相等所需删除字符的 ASCII 值的最小和 。
 * 输入: s1 = "sea", s2 = "eat"
 * 输出: 231
 * 解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
 * 在 "eat" 中删除 "t" 并将 116 加入总和。
 * 结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
 *
 * 链接：https://leetcode.cn/problems/minimum-ascii-delete-sum-for-two-strings
 */

/**
 * 最长公共子序列
 * dp[i][j]代表 s1[i, s1.length - 1]与s2[j, s2.length - 1]的最小删除和
 * int dp(String s1, int start1, String s2, int start2){}
 *
 * 1、start1 == s1.length() -> s2[start2, s2.length - 1]都要被删除
 * 2、...
 * 3、s1.charAt(start1) == s2.charAt(start2)
 *      -> 都不用删除dp[start1][start2] = dp[start1 + 1][start2 + 1]
 * 4、s1.charAt(start1) != s2.charAt(start2)
 *      ->删除一个 dp[start1][start2] =
 *      Math.min(
 *      // 删除 s1.charAt(start1)
 *      dp(s1, start1 + 1, s2, start2) + s1.charAt(start1),
 *      // 或者删除 s2.charAt(start2)
 *      dp(s1, start1, s2, start2 + 1) + s2.charAt(start2));
 */
public class N713两个字符串的最小ASCII删除和 {
    int[][] dp;
    public int minimumDeleteSum(String s1, String s2) {
        dp = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++){
            for (int j = 0; j < s2.length(); j++){
                dp[i][j] = -1;
            }
        }
        return dp(s1, 0, s2, 0);
    }

    int dp(String s1, int start1, String s2, int start2){
        if (start1 == s1.length()){
            int count = 0;
            for (int i = start2; i < s2.length(); i++){
                count += s2.charAt(i);
            }
            return count;
        }
        if (start2 == s2.length()){
            int count = 0;
            for (int i = start1; i < s1.length(); i++){
                count += s1.charAt(i);
            }
            return count;
        }

        if (dp[start1][start2] != -1){
            return dp[start1][start2];
        }

        if (s1.charAt(start1) == s2.charAt(start2)){
            // 都不用删除
            dp[start1][start2] = dp(s1, start1+1, s2, start2 + 1);
        }else{
            // 至少删除一个, 比较最小值
            // dp(s1, start1 + 1, s2, start2) + s1.charAt(start1) 代表删除s1.chraAt(start1)
            dp[start1][start2] = Math.min(dp(s1, start1 + 1, s2, start2) + s1.charAt(start1), dp(s1, start1, s2, start2 + 1) + s2.charAt(start2));
        }

        return dp[start1][start2];
    }
}
