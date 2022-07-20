package per.senawu.algorithm.leetcode.dp;

/**
 * @author Sena-wu
 * @date 2022/7/20
 */

/**
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 *
 * 链接：https://leetcode.cn/problems/longest-palindromic-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 与解最长公共子序列(N1143)思路步骤相似
 * 1、dp[start][end] 代表s[start][end]的最长回文子序列的长度
 * 2、int dp(String s, int start , int end){... return dp[start][end];}
 * 3、s.charAt(start) == s.charAt(end)
 *      -> dp[start][end] = 2 + dp(s, start + 1, end -1);
 * 4、s.charAt(start) != s.charAt(end)
 *      -> dp[start][end] =
 *      Math.max(dp(s, start + 1, end), dp(s, start, end -1));
 */
public class N516最长回文子序列 {
    int[][] dp;
    public int longestPalindromeSubseq(String s) {
        int m = s.length();
        dp = new int[m][m];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < m; j++){
                dp[i][j] = -1;
            }
        }
        return dp(s, 0, m -1);
    }
    int dp(String s, int start , int end){
        if (start == end){
            return 1;
        }
        if (start > end){
            return 0;
        }
        if (dp[start][end] != -1){
            return dp[start][end];
        }

        if (s.charAt(start) == s.charAt(end)){
            dp[start][end] = 2 + dp(s, start + 1, end -1);
        }else{
            dp[start][end] = Math.max(dp(s, start + 1, end), dp(s, start, end -1));
        }

        return dp[start][end];
    }
}
