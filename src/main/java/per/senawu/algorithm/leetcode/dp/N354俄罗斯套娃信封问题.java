package per.senawu.algorithm.leetcode.dp;

/**
 * @author Sena-wu
 * @date 2022/7/1
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 注意：不允许旋转信封。

 * 链接：https://leetcode.cn/problems/russian-doll-envelopes
 */

/**
 * 对二组数组根据nums[i][0] 排序后对nums[i][1]求解最长子序列
 *      先按第一列升序, 第一列值相等按照第二列降序
 *      第二列降序是因为信封必须长宽都要大于才能套娃 第二列升序子序列求解时需要使用nums[i][0]辅助判断 改为降序则不需要
 *
 *  解法二：
 *      在求解最长子序列是使用二分解法降低时间复杂度: 见N300解析
 */
public class N354俄罗斯套娃信封问题 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>(){
            @Override
            public int compare(int a[], int b[]){
                if (a[0] == b[0]){
                    return b[1]-a[1];
                }
                return a[0]-b[0];
            }});
        int dp[]  = new int[envelopes.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < envelopes.length; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
