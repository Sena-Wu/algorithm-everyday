package per.senawu.algorithm.leetcode.binarytree;

/**
 * @author Sena-wu
 * @date 2022/3/30
 */
/**
 * 给定一个二叉树的 root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。
 *
 * 两个节点之间的路径长度 由它们之间的边数表示。
 */

public class N687最长同值路径长度 {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        work(root);
        return max;
    }

    public int work(TreeNode root) {
        if (root == null){
            return 0;
        }

        int left = work(root.left);
        int right = work(root.right);

        if (root.right != null && root.left != null && root.val == root.left.val && root.val == root.right.val){
            // 左右子节点值相同时，以该节点为顶点的最长长度是左子树最长同节点深度 + 左子树最长同节点深度 + 2
            // max = Math.max(max(left, right) + 1, max);
            max = Math.max(max, left + right + 2);
            // 返回值为以该节点为顶点的为同值节点路径深度；而非同值节点路径长度；因为若该节点存在分叉则无法成为上层节点的的路径；只能选择以该节点为顶点的最长深度分支加入上层节点路径构造
            return Math.max(left, right) + 1;

        }else if (root.left != null && root.val == root.left.val){
            max = Math.max(left + 1, max);
            return left + 1;
        }else if(root.right != null && root.val == root.right.val){
            max = Math.max(right + 1, max);
            return right + 1;
        }
        return 0;
    }
}
