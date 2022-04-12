package per.senawu.algorithm.leetcode.binarytree;

/**
 * @author Sena-wu
 * @date 2022/4/10
 */


import java.util.*;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * 一、递归解法
 * 二、非递归解法
 */

public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {

        // 非递归
        ArrayList<Integer> result = new ArrayList();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null){
            return result;
        }
        stack.push(root);
        // root 表示该节点的左节点
        root = root.left;
        while (!stack.isEmpty() || root != null){
            // 节点存在则加入stack，并一直向下探索左子树
            while (root != null){
                stack.push(root);
                root = root.left;
            }

            // 左子节点为空则pop出该节点 将该节点加入结果集
            root = stack.pop();
            result.add(root.val);
            // 遍历右节点
            root = root.right;
        }

        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
