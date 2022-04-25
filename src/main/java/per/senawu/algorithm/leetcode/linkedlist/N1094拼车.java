package per.senawu.algorithm.leetcode.linkedlist;

/**
 * @author Sena-wu
 * @date 2022/4/25
 */

/**
 * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
 * 给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
 * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
 *
 * 链接：https://leetcode-cn.com/problems/car-pooling
 */

/**
 * 差分数组
 * 计算每个站有多少乘客在车上
 * 0 <= fromi < toi <= 1000
 */
public class N1094拼车 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] result = new int[1001];
        for (int[] trip: trips){
            result[trip[1]] += trip[0];
            // 已下车
            result[trip[2]] -= trip[0];
        }
        int count = 0;
        for (int i = 0; i < result.length ;i++){
            count += result[i];
            if (count > capacity){
                return false;
            }
        }
        return true;
    }
}
