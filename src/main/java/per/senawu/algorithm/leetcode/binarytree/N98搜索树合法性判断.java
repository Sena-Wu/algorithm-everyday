package per.senawu.algorithm.leetcode.binarytree;

/**
 * @author Sena-wu
 * @date 2022/4/14
 */

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 *      节点的左子树只包含 小于 当前节点的数。
 *      节点的右子树只包含 大于 当前节点的数。
 *      所有左子树和右子树自身必须也是二叉搜索树。
 *
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class N98搜索树合法性判断 {
    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max){
        if (root == null){
            return true;
        }
        // 左子树要比根节点的值小；右子树要比根节点的值要大

        // 如果有最小值；每个节点都要比最小值大；如果有最大值；每个值都要比最大值小
        if (min != null && root.val <= min.val){return false;}
        if (max != null && root.val >= max.val){return false;}
        // 左子树的最大值是根节点；右子树的最小值是根节点
        boolean left = isValidBST(root.left, min, root);
        boolean right = isValidBST(root.right, root, max);

        return left & right;
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
