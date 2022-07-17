package per.senawu.algorithm.leetcode.dp;

/**
 * @author Sena-wu
 * @date 2022/7/17
 */

/**
 * 给定两个字符串text1 和text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列
 *
 * 链接：https://leetcode.cn/problems/longest-common-subsequence
 */

/**
 * 1、递归
 *      dp(string1, start1, string2, start2)
 *      返回值代表stirng1[start1, end], string2[start2,end]的最长子序列
 *      if (text1.charAt(start1) == text2.charAt(start2)){
 *         memo[start1][start2] = 1 + dp(text1, start1 + 1, text2, start2 + 1);
 *      else:
 *         memo[start1][start2] = Math.max(dp(text1, start1 + 1, text2, start2), dp(text1, start1, text2, start2 + 1));
 *      return memo[start1][start2];
 *
 * 2、迭代
 *      m = text1.length();
 *      n = text2.length();
 *      dp[i][j] 代表string[0, i -1]与string2[0, j - 1]的最长子序列
 *      for (int i = 1; i <= m; i++){
 *          for (int j = 1; j <= n; j++){
 *              if (text1.charAt(i - 1) == text2.charAt(j - 1)){
 *                  dp[i][j] = 1 + dp[i-1][j-1];
 *              }else{
 *                  dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
 *              }
 *          }
 *      }
 *      return dp[m, n]
 */

public class N1143最长公共子序列 {
    int m;
    int n;

    int[][] dp;
    // public int longestCommonSubsequence(String text1, String text2) {
    //     m = text1.length();
    //     n = text2.length();

    //     dp = new int[m+1][n+1];

    //     for (int i = 1; i <= m; i++){
    //         for (int j = 1; j <= n; j++){
    //             if (text1.charAt(i - 1) == text2.charAt(j - 1)){
    //                 dp[i][j] = 1 + dp[i-1][j-1];
    //             }else{
    //                 dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
    //             }
    //         }
    //     }

    //     return dp[m][n];

    // }

    public int longestCommonSubsequence(String text1, String text2) {
        m = text1.length();
        n = text2.length();

        dp = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        return dp(text1, 0, text2, 0);
    }

    int dp(String text1, int start1, String text2, int start2){
        if (start1 == text1.length() || start2 == text2.length()){
            return 0;
        }

        if (dp[start1][start2] != -1){
            return dp[start1][start2];
        }

        if (text1.charAt(start1) == text2.charAt(start2)){
            dp[start1][start2] = 1 + dp(text1, start1 + 1, text2, start2 + 1);
        }else{
            // 不求dp(text1, start1 + 1, text2, start2 + 1)是因为
            // dp(text1, start1 + 1, text2, start2)
            // dp(text1, start1, text2, start2 + 1)
            // 中都包含了对他的计算

            dp[start1][start2] = Math.max(dp(text1, start1 + 1, text2, start2), dp(text1, start1, text2, start2 + 1));
        }
        return dp[start1][start2];
    }
}
