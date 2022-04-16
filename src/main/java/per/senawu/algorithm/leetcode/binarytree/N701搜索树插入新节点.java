package per.senawu.algorithm.leetcode.binarytree;

/**
 * @author Sena-wu
 * @date 2022/4/16
 */

/**
 * 给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 */

/**
 *  1、一直搜索到可以将新节点做为叶子节点插入(实际插入时不一定做为叶子节点)；中间节点进行插入无法保证右子树的值比新节点大，即无法保证新的搜索树的合法性
 *  2、多种插入方式：将新节点做为叶子节点插入；或者将新节点做为根节点，将寻找到的目标节点做为新节点的左子树或右子
 *  3、新节点必定只有有一个孩子或者是一个叶子节点
 */

public class N701搜索树插入新节点 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null){
            return new TreeNode(val);
        }
        TreeNode head = root;
        while (root != null){
            if (val > root.val && root.right == null){
                root.right = new TreeNode(val);
                // 跳出循环
                root = null;
            }else if (val < root.val && root.left == null){
                root.left = new TreeNode(val);
                root = null;
            }else if(val > root.val){
                root = root.right;
            }else{
                root = root.left;
            }
        }
        return head;
    }
}
