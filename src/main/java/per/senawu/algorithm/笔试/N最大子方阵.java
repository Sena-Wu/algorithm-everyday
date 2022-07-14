package per.senawu.algorithm.笔试;

/**
 * @author Sena-wu
 * @date 2022/7/14
 */

import java.util.Scanner;

/**
 * 有个 n × m 的矩阵，找到其中价值最大的子方阵，方阵的价值为四个角上数值之和, 方阵的边长 l >= 2
 * 2<= n,m < 10² ; 1 <= matrix[i][j] <= 10^9
 */

/**
 * 遍历所有顶点 对该顶点遍历所有可能边长的方阵的价值，保留最大值
 */
public class N最大子方阵 {
    static long work(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[][] ints = new long[n][m];
        long max = 0;
        // 遍历矩阵中的顶点
        for (int i = 0; i < n - 1;i++){
            for (int j = 0 ; j < m - 1; j++){
                max = Math.max(max, count(i, j, ints));
            }
        }
        return max;
    }

    // 以matrix[i][j] 为左上顶点, 遍历所有可能边长及计算其矩阵价值, 保留矩阵价值最大值
    static long count(int i, int j, long[][] matrix){
        if (matrix.length - 1 - i < 1){
            return 0;
        }
        if (matrix[0].length - 1 -j < 1){
            return 0;
        }
        long max = 0;
        for (int k = 1; k <= Math.min(matrix[0].length - 1 - j, matrix.length - 1 - i); k++){
            max = Math.max(max, (matrix[i][j] + matrix[i][j+k] + matrix[i+k][j] + matrix[i+k][j+k]));
        }
        return max;
    }
}
