package per.senawu.algorithm.leetcode.binarytree;

/**
 * @author Sena-wu
 * @date 2022/3/30
 */
/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
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
public class Solution543 {
    int result=0;
    public int diameterOfBinaryTree(TreeNode root) {
        work(root);
        return result;
    }

    public int work(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = work(root.left);
        int right = work(root.right);
        result = Math.max(result, (left + right));
        return Math.max(left, right) + 1 ;
    }

}
