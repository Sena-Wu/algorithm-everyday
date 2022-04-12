package per.senawu.algorithm.leetcode.binarytree;

/**
 * @author Sena-wu
 * @date 2022/3/30
 */

/**
 *给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */


public class Solution114 {
    TreeNode head =  new TreeNode();
    TreeNode head1 = head;
    public void flatten(TreeNode root) {
        work(root);
        root = head1.right;
    }

    public void work(TreeNode root){
        if (root != null){
            // 构造新链表
            head.right = root;
            head.left = null;
            head = head.right;
            // 保存右节点; 否则work(root.left)会把root.right改变；导致原root.right丢失
            TreeNode right = root.right;

            work(root.left);
            work(right);
        }


    }

    class TreeNode {
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
