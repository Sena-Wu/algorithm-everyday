package per.senawu.algorithm.leetcode.arr;

/**
 * @author Sena-wu
 * @date 2022/5/6
 */

/**
 * 传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
 *
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * 返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
 * 1 <= days <= weights.length <= 5 * 104
 * 1 <= weights[i] <= 500
 *
 * 链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days
 */

/**
 * 1、确定最低运载能力取值范围
 * 2、二分搜索确定最低运载能力
 */
public class N1011在D天内送达包裹的能力 {
    public int shipWithinDays(int[] weights, int days) {

        // 1 <= days <= weights.length <= 5 * 104
        int[] maxandsum = getMaxAndSum(weights);
        // 最低也得保证能运送任意一个包裹
        int low = maxandsum[0];
        // 最高一天全运完
        int high = maxandsum[1];
        while(low < high){
            int mid = low + (high - low) / 2;
            int need = loadAt(weights, mid);
            if (need > days){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return high;
    }

    // 负载为load需要多少天
    int loadAt(int[] weights, int load){
        int days = 1;
        int once = 0;
        for (int i = 0; i < weights.length;i++){
            once += weights[i];
            if (once > load){
                days++;
                i--;
                once = 0;
            }
        }
        return days;
    }

    int[] getMaxAndSum(int[] nums){
        int max = nums[0];
        int count = nums[0];
        for (int i = 1; i < nums.length; i++){
            max = max > nums[i] ? max : nums[i];
            count += nums[i];
        }
        return new int[]{max, count};
    }
}
