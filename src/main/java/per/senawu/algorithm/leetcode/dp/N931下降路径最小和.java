package per.senawu.algorithm.leetcode.dp;

/**
 * @author Sena-wu
 * @date 2022/7/1
 */

/**
 * 给你一个 n x n 的 方形 整数数组matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 *
 * 链接：https://leetcode.cn/problems/minimum-falling-path-sum
 */

/** 贪心
 * dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i-1][j+1]) + matrix[i][j]
 * 可以从第一行开始往下推算; 空间复杂度为0, matrix可以复用为dp:
 * matrix[i][j] = min(matrix[i-1][j-1], matrix[i-1][j], matrix[i-1][j+1]) + matrix[i][j]
 */
public class N931下降路径最小和 {
    public int minFallingPathSum(int[][] matrix) {
        if (matrix.length == 1){
            return matrix[0][0];
        }
        for (int i = 1; i < matrix.length - 1; i++){
            for (int k = 0; k < matrix.length; k++){
                int leftmin;
                int rightmin;
                if (k == 0){
                    leftmin = matrix[i-1][k];
                    rightmin = Math.min(matrix[i-1][k], matrix[i-1][k+1]);
                }else if(k == matrix.length -1){
                    leftmin = Math.min(matrix[i-1][k], matrix[i-1][k-1]);
                    rightmin = matrix[i-1][k];
                }else{
                    leftmin = Math.min(matrix[i-1][k], matrix[i-1][k-1]);
                    rightmin = Math.min(matrix[i-1][k], matrix[i-1][k+1]);
                }
                matrix[i][k] += Math.min(leftmin, rightmin);
            }
        }
        int i = matrix.length - 1;
        int min = Math.min(matrix[i - 1][0], matrix[i - 1][1]) + matrix[i][0];
        for (int k = 0; k < matrix.length; k++){
            int leftmin;
            int rightmin;
            if (k == 0){
                leftmin = matrix[i-1][k];
                rightmin = Math.min(matrix[i-1][k], matrix[i-1][k+1]);
            }else if(k == matrix.length -1){
                leftmin = Math.min(matrix[i-1][k], matrix[i-1][k-1]);
                rightmin = matrix[i-1][k];
            }else{
                leftmin = Math.min(matrix[i-1][k], matrix[i-1][k-1]);
                rightmin = Math.min(matrix[i-1][k], matrix[i-1][k+1]);
            }
            matrix[i][k] += Math.min(leftmin, rightmin);
            min = Math.min(matrix[i][k], min);
        }
        return min;
    }
}
