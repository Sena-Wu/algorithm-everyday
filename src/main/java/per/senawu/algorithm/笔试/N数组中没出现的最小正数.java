package per.senawu.algorithm.笔试;

import java.util.Arrays;

/**
 * @author Sena-wu
 * @date 2022/7/15
 */

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 * https://leetcode.cn/problems/first-missing-positive/
 */

/**
 * 在元素组上进行更改标记
 *      1、将非正元素更改为一个超过数组容量的值
 *      2、若数组中某元素值i <= nums.length; 则将数组上i - 1位置上的元素变为数, 用以标记i这个整数出现过
 *      3、遍历数组，第一个大于0的元素的下标index + 1 即为未出现的最小整数
 *
 */
public class N数组中没出现的最小正数 {
    public int firstMissingPositive(int[] nums) {
        // 负数改为正数 统一赋值为一个超过数组容量的值即可
        for (int i = 0; i < nums.length; i++){
            if (nums[i] <= 0){
                nums[i] = nums.length + 1;
            }
        }

        // Math.abs(nums[i])代表原数组中的值index
        // 将对应下标index - 1上的数变为负数，代表index这个整除出现过
        // 未出现的正数的取值范围在[1, nums.length + 1]
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]);
            if (index <= nums.length){
                nums[index - 1] = - Math.abs(nums[index - 1]);
            }
        }

        // index 上的数值>0则代表 index + 1未出现过。返回第一个未出现的index + 1
        for(int i = 0; i < nums.length; i++){
            if (nums[i] > 0){
                return i+1;
            }
        }

        // 更改后的数组元素全<0, 表示[1, nums.length]正数全部出现过, 故返回nums.length + 1
        return nums.length + 1;
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        // 下一个该出现的正数
        int result = 1;
        for (int i = 0; i < A.length; i++){
            if (A[i] <= 0){
                continue;
            }
            if (A[i] == result){
                result++;
            }
            if(A[i] > result){
                break;
            }
        }
        return result;
    }
}
