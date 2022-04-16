package per.senawu.algorithm.leetcode.binarytree;

/**
 * @author Sena-wu
 * @date 2022/3/30
 */

/**
 * 给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵树的后序遍历，重构并返回二叉树。
 * 如果存在多个答案，您可以返回其中任何 一个。(preorder与postorder不能唯一确定一颗树)
 */

public class N889根据先序后序结果构造二叉树 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return work(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);

    }

    public TreeNode work(int[] preorder,int start, int end, int[] postorder,int l, int r){
        if (start > end){
            return null;
        }

        TreeNode root = new TreeNode(preorder[start]);
        if (start == end){
            return root;
        }
        int index = getindex(postorder, preorder[start + 1]);

        TreeNode left = work(preorder, start + 1, start + 1 + index - l ,postorder, l, index);
        TreeNode right = work(preorder, start + 2 + index - l, end, postorder, index + 1 , r - 1);

        root.left = left;
        root.right = right;

        return root;
    }

    public int getindex(int[] postorder, int target){
        for (int i = 0; i < postorder.length; i++){
            if (postorder[i] == target){
                return i;
            }
        }
        return -1;
    }
}
