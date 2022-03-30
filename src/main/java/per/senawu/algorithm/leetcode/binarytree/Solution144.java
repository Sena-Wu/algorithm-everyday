package per.senawu.algorithm.leetcode.binarytree;

/**
 * @author Sena-wu
 * @date 2022/3/30
 */

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
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
public class Solution144 {
    List<Integer> result = new ArrayList();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null){
            return Collections.emptyList();
        }

        result.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return result;
    }
}
