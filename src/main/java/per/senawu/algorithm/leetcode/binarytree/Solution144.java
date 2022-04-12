package per.senawu.algorithm.leetcode.binarytree;

/**
 * @author Sena-wu
 * @date 2022/3/30
 */

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * 一、递归解法
 * 二、非递归解法
 */

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;


public class Solution144 {
    List<Integer> result = new ArrayList();
    public List<Integer> preorderTraversal(TreeNode root) {
        // 递归
//        if (root == null){
//            return Collections.emptyList();
//        }
//
//        result.add(root.val);
//        preorderTraversal(root.left);
//        preorderTraversal(root.right);
//        return result;

        // 非递归
        ArrayList<Integer> result = new ArrayList();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null){
            return result;
        }
        result.add(root.val);
        stack.push(root);
        // root 表示该节点的左节点
        root = root.left;
        while (!stack.isEmpty() || root != null){
            // 节点存在则加入结果集，并一直向下探索左子树
            while (root != null){
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }
            // 左子节点为空则pop出该节点
            root = stack.pop();
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
