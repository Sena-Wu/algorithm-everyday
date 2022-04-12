package per.senawu.algorithm.leetcode.binarytree;

/**
 * @author Sena-wu
 * @date 2022/3/30
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 */



public class Solution116 {
    public Node connect(Node root) {
        // 层次遍历
        Queue<Node> queue = new LinkedList<Node>();
        if (root == null){
            return null;
        }
        Node work;
        queue.offer(root);
        while(queue.size() != 0){
            int count = queue.size();

            Node next = null;
            for (int i = 0; i < count; i++){
                work = queue.poll();
                try{
                    work.next = next;
                    next = work;
                    // 先放右节点再放左节点，；这样可以在循环中先处理并记录work的右侧节点，便于操作work.next
                    queue.offer(work.right);
                    queue.offer(work.left);
                }catch (Exception e){
                }
            }
        }
        return root;

    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}
