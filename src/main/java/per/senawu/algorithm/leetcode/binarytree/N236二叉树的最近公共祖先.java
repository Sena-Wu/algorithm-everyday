package per.senawu.algorithm.leetcode.binarytree;

import java.util.ArrayList;

/**
 * @author Sena-wu
 * @date 2022/4/18
 */

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 *说明：p、q 为不同节点且均存在于给定的二叉搜索树
 *
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 */

/**
 * 后序遍历得到以root为根节点的树的所有节点列表
 *
 * p q 在节点列表中并且最近祖先节点还未确定则root就是最近的最先节点
 * 若最近祖先节点以经确定， root 只是 p q 的一个上层祖先节点
 *
 * 与搜索树不同，处理搜索树的算法中能保证p q都在以root为根节点的树中
 * 但普通的二叉树则不能保证这点；所以需要获取以root为根节点的所有节点才能判断root子树是否包含p q
 */
public class N236二叉树的最近公共祖先 {
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        work(root, p, q);
        return res;
    }

    public ArrayList<TreeNode> work(TreeNode root, TreeNode p, TreeNode q){
        if (root == null){
            return new ArrayList<TreeNode>();
        }
        ArrayList<TreeNode> left = work(root.left, p, q);
        ArrayList<TreeNode> right = work(root.right, p, q);

        // 以root为根节点的所有节点，判断p、q是否在这颗树中, 以及是否已经找最近根节点
        left.addAll(right);
        left.add(root);
        if (left.contains(p) && left.contains(q) && res == null){
            res = root;
        }
        return left;
    }
}
