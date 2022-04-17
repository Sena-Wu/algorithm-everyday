package per.senawu.algorithm.leetcode.binarytree;

/**
 * @author Sena-wu
 * @date 2022/4/17
 */

/**
 * 给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和(搜索树节点和最大)。
 * 二叉搜索树的定义如下：
 *      任意节点的左子树中的键值都 小于 此节点的键值。
 *      任意节点的右子树中的键值都 大于 此节点的键值。
 *      任意节点的左子树和右子树都是二叉搜索树。
 *
 * 链接：https://leetcode-cn.com/problems/maximum-sum-bst-in-binary-tree
 */

/**
 * 后续遍历
 * 需要获取子树的最大值，最小值、和、是否是搜索树
 * 判断root的左右子树是否是二叉树，根据左右子树的最大值最小值来判断root是否是搜索树
 * 若root是搜索树 根据左右子树节点和计算root的节点和；并将节点和与最大的节点和进行比较取最大值
 */
public class N1373最大搜索子树 {
    // 最大值非负; 若搜索树的节点和为负数, 则返回0
    int max = 0;
    public int maxSumBST(TreeNode root) {
        work(root);
        return max;

    }
    // 记录每一颗子树的最大值，最小值、和、是否是搜索树
    public int[] work(TreeNode root){
        if (root == null){
            return new int[]{0,0,0,1};
        }
        int[] left = work(root.left);
        int[] right = work(root.right);

        int[] result = new int[]{0,0,0,0};

        // 左右子树都是搜索树并且root的值大于左子树的最大值;小于右子树的最小值;则root也是一颗搜索树
        if (left[3] == 1 && right[3] == 1){
            if ((root.val < right[1] || root.right == null) && (root.val > left[0] || root.left == null)){
                result[3] = 1;
            }
        }
        // root 是一颗搜索树则计算最大值、最小值、和
        // 空节点最大值、最小值、和返回值为0，需特殊处理
        if (result[3] == 1){
            if(root.left == null && root.right == null){
                // 最大值
                result[0] = root.val;
                // 最小值
                result[1] = root.val;
                // 和
                result[2] = root.val;
            }else if (root.left == null){
                result[0] = right[0];
                result[1] = root.val;
                result[2] = right[2] + root.val;
            }else if (root.right == null){
                result[0] = root.val;
                result[1] = left[1];
                result[2] = left[2] + root.val;
            }else{
                result[0] = right[0];
                result[1] = left[1];
                result[2] = right[2] + left[2] + root.val;
            }
            max = Math.max(max, result[2]);
        }
        return result;
    }
}
