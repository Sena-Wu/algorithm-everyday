package per.senawu.algorithm.leetcode.binarytree;

/**
 * @author Sena-wu
 * @date 2022/4/16
 */

/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 */

/**
 * 以该有序序列的任一一个元素为根构建二叉树，该元素左侧构成左子树，右侧构成右子树；该二叉树的种树为左子树的种数 x 右子树的种数；因此将问题分解为左右子树的种数；
 * 算法中用memo[i][j]用你记录[i,j]区间构造搜索树的种数，避免计算重复子区间
 *
 * 将该题引申；求解任一给定数组可能构造的搜索树的种树
 * 1、计算该数组的长度len;直接转化为本题：n = len即可得出结果
 *
 * 不用在意具体的数字，只需要关心他们的有序关系。
 * 无论具体数字是什么，在排序后的第i个位置，它的左子树是范围是[0,i-1] 右子树的范围[i+1, len-1]
 */
public class N96可以构造多少种不同搜索树 {
    int[][] memo;
    int numTrees(int n) {
        // n+2 方便work访问memo index溢出；懒得做判断
        memo = new int[n+2][n+2];
        work(1, n);
        return memo[1][n];

    }

    int work(int low, int hight){
        // 记录该区间的所有可能种数
        int res = 0;
        if (low > hight){
            return 1;
        }
        for (int i = low;i <= hight; i++){
            int left = memo[low][i-1];
            int right = memo[i+1][hight];
            if (left == 0){
                left = work(low, i-1);
            }
            if (right == 0){
                right = work(i+1, hight);
            }
            res += right * left;
        }
        memo[low][hight] = res;
        return res;
    }
}
