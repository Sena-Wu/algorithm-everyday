package per.senawu.algorithm.笔试;

import java.net.URI;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Sena-wu
 * @date 2022/7/14
 */

/**
 * 对 n 个城市的旅游情况进行了规划, 每个城市都有两种属性 x, y; x 表示去该城市旅游需要的花费, y表示去该城市获取的开心值, 现在希望挑选一些城市去旅游, 但必须满足一个条件: 挑选的城市中 任意两个城市之间的旅游花费的差值不超过K, 求满足该条件下的能获取到的开心值最大有多少; 旅游经费不限
 */

/**
 * 1 把 n个城市按照旅游花费进行升序排序, 寻找所有满足条件的子区间 -> 区间首尾城市花费值 <= k, 那区间内的自然也满足条件;
 *
 * 2 计算区间内所有城市的开心值, 子区间求和 可以用前缀和省去重复计算
 * 3 保留开心值最大值
 */
public class N旅游规划 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++){
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }
        // 把城市按照花费排序
        Arrays.sort(nums, (o1, o2) -> o1[0] - o2[0]);
        int[] sum = new int[n];
        sum[0] = 0;
        // 花费前缀和
        for (int i = 1; i <= n; i++){
            sum[i] = nums[i-1][1] + sum[i - 2];
        }

        int max = 0;
        // 遍历所有可能子区间
        for (int i = 0; i < n; i++){
            // 以i为左边界, 寻找满足条件的最大右边界
            int next = getNext(i, n - 1, nums[i][0] + k + 1, nums);
            // 计算区间内的花费, 保留最大值
            max = Math.max(max, sum[next + 1] - sum[i]);
        }
        System.out.println(max);
    }
    // 在升序列表中寻找最后一个值不大于target的元素下标
    static int getNext(int l, int r, int target, int[][] nums){
        int left = l;
        int right = r;
        while (l < r){
            int mid = (l + r + 1) / 2;
            if (nums[mid][0] < target){
                left = mid;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
