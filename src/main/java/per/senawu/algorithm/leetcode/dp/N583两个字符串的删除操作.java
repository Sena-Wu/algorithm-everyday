package per.senawu.algorithm.leetcode.dp;

/**
 * @author Sena-wu
 * @date 2022/7/17
 */

/**
 * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
 * 每步 可以删除任意一个字符串中的一个字符。
 *
 * https://leetcode.cn/problems/delete-operation-for-two-strings/
 */

/**
 * 走一步删除一个字符; 最终保留的字符串越长 步数越少, 保留的字符串是一定是公共子序列
 * 需要减去的字符的数量 = 两个字符串总长 - 2 * 字符串最长公共子序列的长度
 * 所以这道题就转化为 求字符串的公共最长子序列
 */
public class N583两个字符串的删除操作 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (word1.charAt(i - 1) == word2.charAt(j -1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j -1]);
                }
            }
        }

        return m + n - 2 * dp[m][n];
    }
}
