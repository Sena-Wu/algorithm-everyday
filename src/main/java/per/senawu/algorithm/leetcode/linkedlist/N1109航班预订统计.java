package per.senawu.algorithm.leetcode.linkedlist;

/**
 * @author Sena-wu
 * @date 2022/4/24
 */

/**
 *输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 * 解释：
 * 航班编号        1   2   3   4   5
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       20  20
 * 预订记录 3 ：       25  25  25  25
 * 总座位数：      10  55  45  25  25
 * 因此，answer = [10,55,45,25,25]
 *
 * 链接：https://leetcode-cn.com/problems/corporate-flight-bookings
 */
public class N1109航班预订统计 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // 构造差分数组 初始值为0
        int [] result = new int[n];
        for (int[] booking: bookings){
            result[booking[0] - 1] += booking[2];
            if(booking[1] < n){result[booking[1]] -= booking[2];}
        }

        // 计算结果
        int count = 0;
        for (int i = 0; i < n; i++){
            count += result[i];
            result[i] = count;
        }
        return result;
    }
}
