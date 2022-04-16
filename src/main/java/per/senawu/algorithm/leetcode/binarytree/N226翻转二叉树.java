package per.senawu.algorithm.leetcode.binarytree;

/**
 * @author Sena-wu
 * @date 2022/3/30
 */

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */

public class N226翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }

        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
