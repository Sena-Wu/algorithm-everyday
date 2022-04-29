package per.senawu.algorithm.leetcode.arr;

/**
 * @author Sena-wu
 * @date 2022/4/29
 */

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * 链接：https://leetcode-cn.com/problems/rotate-image
 */

/**
 * 图像顺时针旋转 90 度: 第一行变为倒数第一列 ; 第 n 行变为倒数第 n 列
 * 一、分解
 *      1、行转列, 第一行转第一列, 沿(0, 0)(n, n)轴线反转即可
 *      2、列反转, 第一列转倒数第一列
 */
public class N48旋转图像 {
    public void rotate(int[][] matrix) {
        work1(matrix);
        work2(matrix);
    }
    // 沿(0, 0)...(n, n) 对称转换 : 行转为列
    void work1(int[][] matrix){
        for (int i = 0; i < matrix.length; i ++){
            for(int j = i + 1; j < matrix.length; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    // 按列逆转
    void work2(int[][] matrix){
        // 列
        int low = 0;
        int high = matrix.length -1;
        while(low < high){
            // i 行
            for (int i = 0; i < matrix.length; i ++){
                int tmp = matrix[i][high];
                matrix[i][high] = matrix[i][low];
                matrix[i][low] = tmp;
            }
            low++;
            high--;
        }
    }
}
