package per.senawu.algorithm.leetcode.binarytree;

/**
 * @author Sena-wu
 * @date 2022/4/16
 */
import java.util.ArrayList;
import java.util.List;
/**
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/submissions/
 */

/**
 * 1、穷举root节点的所有可能。
 * 2、递归构造出左右子树的所有合法 BST。
 * 3、给root节点穷举所有左右子树的组合
 */
public class N95构造所有可能的搜索树 {
    public List<TreeNode> generateTrees(int n) {
        return work(1,n);

    }
    public List<TreeNode> work(int low, int hight){
        ArrayList<TreeNode> result = new ArrayList();
        if (low > hight){
            result.add(null);
        }
        for (int i = low; i <= hight; i++){
            // 所有可能的合法左子树
            List<TreeNode> leftList = work(low, i-1);
            // 所有可能的合法右子树
            List<TreeNode> rightList = work(i+1, hight);
            // 以i为根节点，所有可能的搜索树
            for(TreeNode left: leftList){
                for(TreeNode right: rightList){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        // 区间[low, hight]内所有可能的搜索树
        return result;
    }
}
