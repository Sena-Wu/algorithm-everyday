package per.senawu.algorithm.leetcode.arr;

/**
 * @author Sena-wu
 * @date 2022/5/2
 */

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 */
public class N59螺旋矩阵生成 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int low = 0;
        int high = n - 1;
        int left = 0;
        int right = n - 1;
        int count = 0;
        while (count < n * n){
            // 上行
            for (int i = left; i <= right; i++){
                matrix[low][i] = ++count;
            }

            // 右列
            for (int i = low + 1; i <= high; i++){
                matrix[i][right] = ++count;
            }

            // 下行
            for (int i = right-1; i >= left && low != high; i--){
                matrix[high][i] = ++count;
            }

            // 左列
            for (int i = high - 1; i > low && left != right; i--){
                matrix[i][left] = ++count;
            }
            low++;
            high--;
            left++;
            right--;
        }
        return matrix;
    }
}
