package per.senawu.algorithm.leetcode.binarytree;

/**
 * @author Sena-wu
 * @date 2022/3/30
 */

/**
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 *
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return work(nums, 0, nums.length-1);
    }

    public TreeNode work(int[] nums, int start, int end) {
        if (start > end){
            return null;
        }
        TreeNode root = new TreeNode();
        int max = getmax(nums, start, end);
        root.val = nums[max];
        TreeNode left = work(nums, start, max-1);
        TreeNode right = work(nums, max + 1 ,end);

        root.left = left;
        root.right = right;

        return root;
    }

    public int getmax(int[] nums, int start, int end){
        if (start == end){
            return start;
        }
        int index = start;
        int tmp = nums[start];
        for (int i = start + 1; i <= end; i++){
            if (nums[i] > tmp){
                index = i;
                tmp = nums[i];
            }
        }
        return index;
    }
}
