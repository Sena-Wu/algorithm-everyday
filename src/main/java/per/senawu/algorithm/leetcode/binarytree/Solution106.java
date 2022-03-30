package per.senawu.algorithm.leetcode.binarytree;

/**
 * @author Sena-wu
 * @date 2022/3/30
 */

/**
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
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
public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return work(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    public TreeNode work(int[] inorder,int start, int end, int[] postorder,int l, int r){
        if (start > end){
            return null;
        }

        TreeNode root = new TreeNode(postorder[r]);
        int index = getindex(inorder, postorder[r]);

        TreeNode left = work(inorder, start, index - 1, postorder, l, l + index - 1 - start);
        TreeNode right = work(inorder, index + 1, end, postorder,l + index - start , r - 1);

        root.left = left;
        root.right = right;

        return root;

    }

    public int getindex(int[] inorder, int target){
        for (int i = 0; i < inorder.length; i ++ ){
            if (inorder[i] == target){
                return i;
            }
        }
        return -1;
    }
}
