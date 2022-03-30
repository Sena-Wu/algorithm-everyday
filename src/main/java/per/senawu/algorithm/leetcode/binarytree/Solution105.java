package per.senawu.algorithm.leetcode.binarytree;

/**
 * @author Sena-wu
 * @date 2022/3/30
 */

/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
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
public class Solution105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return work(preorder, 0, preorder.length - 1, inorder, 0, inorder.length-1);
    }

    public TreeNode work(int[] preorder,int start, int end, int[] inorder,int l, int r){
        if (start > end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);
        int index = getindex(inorder, preorder[start]);
        // start = start_old + 1, end = start + 左子树节点数 - 1; 左子树节点数 = index - 1 - l + 1
        TreeNode left = work(preorder, start + 1, start + index - l , inorder, l, index - 1);
        TreeNode right = work(preorder, start + 1 + index - l, end, inorder, index + 1, r);

        root.left = left;
        root.right = right;

        return root;

    }

    public int getindex(int[] inorder, int target){
        for (int i = 0; i < inorder.length; i++){
            if (inorder[i] == target){
                return i;
            }
        }
        return -1;
    }
    
}
