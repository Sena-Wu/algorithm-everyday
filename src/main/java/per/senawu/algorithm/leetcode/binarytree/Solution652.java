package per.senawu.algorithm.leetcode.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Sena-wu
 * @date 2022/4/14
 */

/**
 * 给定一棵二叉树 root，返回所有重复的子树。
 * 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
 */
public class Solution652 {
    HashMap<String, Integer> trees = new HashMap();
    ArrayList<TreeNode> res = new ArrayList();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        work(root);
        return res;
    }

    public String work(TreeNode root){
        if (root == null){
            return "#";
        }
        String left = work(root.left);
        String right = work(root.right);

        // 每棵子树的序列化结果
        // 不加逗号分割有一些测试用例通不过
        // 已解决，举例：
        // 加分隔符：11,1,#  ； 1,11,# ；不同的两颗子树
        // 不加分隔符：111#  ；111#    ；相同的两颗子树
        // String subTree = root.val + left + right;
        String subTree = root.val + "," + left + "," + right;

        // 序列化结果之前以加入trees,则存在相同的子树
        int nums = trees.getOrDefault(subTree, 0);
        if (nums == 1){
            res.add(root);
        }
        trees.put(subTree, nums + 1);

        return subTree;
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
