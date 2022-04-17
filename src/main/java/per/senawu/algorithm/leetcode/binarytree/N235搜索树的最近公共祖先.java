package per.senawu.algorithm.leetcode.binarytree;

/**
 * @author Sena-wu
 * @date 2022/4/17
 */

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 说明：p、q 为不同节点且均存在于给定的二叉搜索树
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 */

/**
 * 自顶向下遍历
 * 根据搜索树的特性
 * 若p、q一个值大于root一个小于root，则root肯定就是他们的最近祖先节点
 * 若p、q中其中有一个值等于root，则root肯定是它的祖先节点
 * 若p、q都小于root，则他们的最近祖先节点一定在root的左子树中
 * 若p、q都大于root，则他们的最近祖先节点一定在root的右子树中
 */
public class N235搜索树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return work(root, p.val, q.val);
    }
    public TreeNode work(TreeNode root, int p, int q){
        if (p < root.val && root.val < q || q < root.val && root.val < p || root.val == p || root.val == q){
            return root;
        }
        if (p < root.val && q < root.val){
            return work(root.left, p, q);
        }else{
            return work(root.right, p, q);
        }
    }
}
