package per.senawu.algorithm.leetcode.arr;

/**
 * @author Sena-wu
 * @date 2022/5/6
 */

/**
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 *
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 * 1 <= piles.length <= 104
 * piles.length <= h <= 109
 * 1 <= piles[i] <= 109
 *
 * 链接：https://leetcode-cn.com/problems/koko-eating-bananas
 */

/**
 * 确定最小速度K的取值范围
 * 二分搜索确定最小速度 k
 */
public class N875吃掉所有香蕉的最小速度K {
    public int minEatingSpeed(int[] piles, int h) {
        // piles 递增
        // piles.length <= h
        if(piles.length == h){
            return getMax(piles);
        }
        // 最小速度 k的范围一定在[slow, fast]
        // 以fast一定能在h小时内吃完
        int slow = 1;
        int fast = getMax(piles);
        while (slow < fast){
            int mid = slow + (fast - slow) / 2;
            int spend = speedAt(piles, mid);
            // 还可能存在更小值 虽然速度不同但是耗时可能一致
            // if (spend == h){
            //     return mid;
            // }
            // 速度得加快点
            if (spend > h){
                slow = mid + 1;
            }else if (spend <= h){
                fast = mid;
            }
        }
        return fast;
    }

    int getMax(int[] nums){
        int max = nums[0];
        for (int i = 1;i < nums.length; i++){
            max = max > nums[i] ? max : nums[i];
        }
        return max;
    }

    // 以该速度需要耗时多久吃完
    int speedAt(int[] piles, int speed){
        int count = 0;
        for (int i = 0;i < piles.length; i++){
            count += (int) Math.ceil((double)piles[i] / speed);
        }
        return count;
    }
}
