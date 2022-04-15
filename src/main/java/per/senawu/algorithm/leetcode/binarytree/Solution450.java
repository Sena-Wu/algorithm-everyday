package per.senawu.algorithm.leetcode.binarytree;

/**
 * @author Sena-wu
 * @date 2022/4/15
 */

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 */
public class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode head = root;
        TreeNode prenode = null;
        while(root != null){
            if (root.val == key){
                if (root.right == null && root.left == null){
                    // root 是根节点
                    if (prenode == null){
                        return null;
                    }
                    if (prenode.right == root){
                        prenode.right = null;
                    }else{prenode.left = null;}
                    // 跳出while
                    root = null;
                }else if (root.right == null && root.left != null){
                    // 只有左子树
                    // root 是根节点
                    if (prenode == null){
                        return root.left;
                    }
                    if (prenode.right == root){
                        prenode.right = root.left;
                    }else{prenode.left = root.left;}
                    // 跳出while
                    root = null;
                }else if (root.right != null && root.left == null){
                    // 只有右子树
                    // root 是根节点
                    if (prenode == null){
                        return root.right;
                    }
                    if (prenode.right == root){
                        prenode.right = root.right;
                    }else{prenode.left = root.right;}
                    // 跳出while
                    root = null;
                }else{
                    // 有左右子树
                    TreeNode min = getMin(root.right);
                    TreeNode rightAfter = deleteMin(root.right);
                    min.right = rightAfter;
                    min.left = root.left;
                    if (prenode == null){
                        return min;
                    }
                    if (prenode.right == root){
                        prenode.right = min;
                    }else{prenode.left = min;}
                    root = null;
                }
            }else if(root.val > key){
                prenode = root;
                root = root.left;
            }else if(root.val < key){
                prenode = root;
                root = root.right;
            }
        }
        return head;
    }

    // 获取二叉搜索树的最小节点
    public TreeNode getMin(TreeNode root){
        if (root != null){
            while(root.left != null){
                root = root.left;
            }
        }
        return root;
    }
    // 删除一颗树的最小节点 并返回该树的根节点
    public TreeNode deleteMin(TreeNode root){

        if (root.left == null && root.right == null){return null;}
        TreeNode head = root;
        // root 存在左子树；寻找最左节点
        if (root.left != null){
            // 左子节点是否存在左子节点
            while(root.left.left != null){
                root = root.left;
            }
            // root.left是待删出节点
            // root.left是否是叶子节点
            if (root.left.right == null){
                root.left = null;
            }else{
                root.left = root.left.right;
            }
            return head;
        }
        // root的左子树为空
        return root.right;
    }

}
