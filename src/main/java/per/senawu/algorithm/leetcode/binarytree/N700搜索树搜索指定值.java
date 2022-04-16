package per.senawu.algorithm.leetcode.binarytree;

/**
 * @author Sena-wu
 * @date 2022/4/16
 */

/**
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 */

public class N700搜索树搜索指定值 {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null){
            if (root.val == val){
                return root;
            }else if (root.val < val){
                root = root.right;
            }else{
                root = root.left;
            }
        }
        // root为空或者未找到指定值
        return null;
    }
}
