package per.senawu.algorithm.leetcode.arr;

/**
 * @author Sena-wu
 * @date 2022/5/1
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * https://leetcode-cn.com/problems/spiral-matrix/
 */
public class N54螺旋矩阵 {
     public List<Integer> spiralOrder(int[][] matrix) {
          int total = matrix.length * matrix[0].length;
          List<Integer> result = new ArrayList(matrix.length * matrix[0].length);
          int low = 0;
          int high = matrix.length - 1;
          int left = 0;
          int right = matrix[0].length - 1;

          while(result.size() < total){
               // 第low行
               for (int i = left; i <= right; i++){
                    result.add(matrix[low][i]);
               }

               // 第right列 , 除第一个 已在第low行处理了
               for (int i = low + 1; i <= high; i++){
                    result.add(matrix[i][right]);
               }

               // 第high行, 除第一个 已在第right列处理了
               // && low < high 矩阵是单行导致与第low行重复输出
               for (int i = right - 1; i >= left && low < high; i--){
                    result.add(matrix[high][i]);
               }

               // 第left列 , 除第一个 和 最后一个
               // && left < right 矩阵是单列导致与第right列重复输出
               for (int i = high - 1; i > low && left < right; i--){
                    result.add(matrix[i][left]);
               }

               left++;
               right--;
               low++;
               high--;

          }
          return result;
     }
}
