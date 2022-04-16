package per.senawu.algorithm.leetcode.binarytree;

/**
 * @author Sena-wu
 * @date 2022/4/10
 */
import java.util.Arrays;
import java.util.LinkedList;


/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 */

/**
 * 只通过前、中、后序结果无法唯一的确认一棵树、必须要通过中序再加前序或后序才可唯一确定一颗树；
 * 但是若将二叉树中的空节点也一同保存下来，则它的前序结果可以唯一的确定一颗二叉树
 */
public class N297序列化二叉树 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "#";
        }

        String left = serialize(root.left);
        String right = serialize(root.right);

        return root.val + "," + left + "," + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tree = data.split(",");
        return work_deserialize(new LinkedList<String>(Arrays.asList(tree)));
    }

    private TreeNode work_deserialize(LinkedList<String> data){
        String first = data.removeFirst();
        if (first.equals("#")){
            return null;
        }
        System.out.println(data.get(0));
        TreeNode root =  new TreeNode(Integer.parseInt(first));
        TreeNode left = work_deserialize(data);
        TreeNode right = work_deserialize(data);

        root.left = left;
        root.right = right;

        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
