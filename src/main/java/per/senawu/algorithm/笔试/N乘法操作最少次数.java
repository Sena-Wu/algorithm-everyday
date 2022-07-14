package per.senawu.algorithm.笔试;

/**
 * @author Sena-wu
 * @date 2022/7/14
 */

import com.sun.media.sound.RIFFInvalidDataException;

import java.util.Scanner;

/**
 * 对一个数存在两种操作, 乘以x 或乘以 y, 操作次数没有限制; 现在有数字a, 问最少需要多少次操作把a变成b
 * 2<= x,y < 10² ; 1 <= a, b <= 10^9
 */

/**
 * dfs
 * 可以把nums中的元素按照升序排列， 这样无需保存中间状态取最大值， 一旦有返回值即可立即返回结束程序
 * 先 ×大的数如果可行 自然次数是最少的
 */
public class N乘法操作最少次数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int[] nums = new int[2];
        if (x > y){
            nums[0] = x;
        }else {
            nums[0] = y;
        }
        nums[1] = x + y - nums[0];
        System.out.println(work(nums, a, b, 0));
    }
    static int work(int[] nums, int a, int b, int count){
        if (a == b){
            return count;
        }
        if (a > b){
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            int result = work(nums, a * nums[i], b, count + 1);
            return result;
        }

        return -1;

//        int left = work(nums, a * nums[0], b, count + 1);
//        if (left != -1){
//            return left;
//        }
//
//        int right = work(nums, a * nums[1], b, count + 1);
//        if (right != -1){
//            return right;
//        }
//        return -1;
    }
}
