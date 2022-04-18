package per.senawu.algorithm.leetcode.binarytree;

/**
 * @author Sena-wu
 * @date 2022/4/18
 */

/**
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 *
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~2h个节点。
 * 
 * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 */

/**
 * 解法一：遍历一遍二叉树
 * 解法二：根据完全二叉树，满二叉树的特性，若root左右子树高度相同，则是满二叉树，直接根据层高计算总节点数
 *  若左右子树高度不相同，递归的计算左右子树的总结点数；左右子树中一定至少有一个是满二叉树;
 *  也就是说左右子树至多有一个会需要继续递归来计算总结点
 */
public class N222计算完全二叉树的结点个数 {
    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }

        TreeNode l = root.left, r = root.right;
        int hl = 0, hr = 0;
        // 判断是否是满二叉树
        while(l != null){
            l = l.left;
            hl++;
        }
        while(r != null){
            r = r.right;
            hr++;
        }
        // 满二叉树直接根据树高计算总结点
        if( hr == hl){
            return (int) (Math.pow(2, hr + 1) -1);
        }

        // 不是满二叉; 但root.left 、root.right 必然有一个是满二叉
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
