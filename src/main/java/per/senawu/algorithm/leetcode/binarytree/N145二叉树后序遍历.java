package per.senawu.algorithm.leetcode.binarytree;

/**
 * @author Sena-wu
 * @date 2022/4/12
 */

import sun.awt.image.ShortInterleavedRaster;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * 一、递归解法
 * 二、非递归解法
 */
public class N145二叉树后序遍历 {

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        if (root == null){
            return result;
        }
        TreeNode prenode = null;
        stack.push(root);
        root = root.left;

        // while(1)
        // 根节点需要在左右子树都处理过后才pop出来，所以判断条件只需!stack.isEmpty()
        while (!stack.isEmpty()){
            // while(2)
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            if (root.right == prenode || root.right == null){
                prenode = root;
                stack.pop();
                result.add(root.val);
                // 右子树为空或已经处理；root赋为null,下一轮while(1)中会跳过while(2); 直接peek上层节点
                root = null;
            }else{
                // 右子树还未处理, 下一轮while(2)继续处理
                root = root.right;
            }

        }

        return result;

        // 非递归:2
        // LinkedList<Integer> result = new LinkedList();
        // LinkedList<TreeNode> stack = new LinkedList();

        // if (root == null){
        //     return result;
        // }
        // stack.push(root);
        // while (! stack.isEmpty()){
        //     root = stack.pop();
        //     if (root.left != null){
        //         stack.push(root.left);
        //     }
        //     if (root.right != null){
        //         stack.push(root.right);
        //     }
        //     result.push(root.val);
        // }
        // return result;

        // 非递归:3
//        LinkedList<Integer> result = new LinkedList<>();
//        LinkedList<TreeNode> stack = new LinkedList<>();
//
//        if (root == null){
//            return result;
//        }
//
//        // while(1)
//        // 写法与前序基本一致；只需将左右子树的遍历顺序改变；再将结果集逆转（所以这里使用了stack结构）
//        while (!stack.isEmpty() || root != null){
//            while(root != null){
//                stack.push(root);
//                result.push(root.val);
//                root = root.right;
//            }
//            root = stack.pop();
//            root = root.left;
//        }
//        return result;

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
