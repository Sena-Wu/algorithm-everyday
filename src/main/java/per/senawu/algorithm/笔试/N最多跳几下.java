package per.senawu.algorithm.笔试;

/**
 * @author Sena-wu
 * @date 2022/7/15
 */

/**
 * 给定一个数组, 数值代表高度
 * 一个青蛙只能往更高处跳，但是可以从任一位置[0, len]开始跳; s[j] >= s[i] 可以从i到j ,j 与 i 相邻
 * 求最远的跳跃范围的长度，右边最远下标 - 左边最远下标 + 1
 */
public class N最多跳几下 {
    public int solution(int[] blocks) {
        // write your code in Java SE 8
        int max = 0;
        for (int i = 0; i < blocks.length; i++){
            int left = i;
            int right = i;
            while(left > 0 && blocks[left - 1] >= blocks[left]){
                left--;
            }
            while(right < blocks.length - 1 && blocks[right + 1] >= blocks[right]){right++;}
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
