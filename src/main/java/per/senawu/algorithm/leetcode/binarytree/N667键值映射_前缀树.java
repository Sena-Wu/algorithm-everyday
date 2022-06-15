package per.senawu.algorithm.leetcode.binarytree;

/**
 * @author Sena-wu
 * @date 2022/6/15
 */

/**
 * 设计一个 map ，满足以下几点:
 *
 * 字符串表示键，整数表示值
 * 返回具有前缀等于给定字符串的键的值的总和
 * 实现一个 MapSum 类：
 *
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对 key-value 将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 *
 * 链接：https://leetcode.cn/problems/map-sum-pairs
 */

/**
 * 多叉树节点结构设计：
 *     class Node{
 *         char[] prefixValCount = new char[26];  count[index]表示以该前缀开头的可以的值的总和
 *         int[] keys = new int[26];  key值; 等于0表示root到count[index]的路径只是前缀 ，否则为key, key[index]为该key的值；
 *         Node[] children = new Node[26];  子节点
 *     }
 * key 和 prefix 仅由小写英文字母组成
 * 1 <= val <= 1000
 */
public class N667键值映射_前缀树 {
    private Node root = new Node();
    public N667键值映射_前缀树() {
    }

    public void insert(String key, int val) {
        updateTree(root, key, 0, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        Node work = root;
        for (int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if (work == null || work.prefixValCount[index] == 0 ){
                return 0;
            }else{
                sum = work.prefixValCount[index];
                work = work.children[index];
            }
        }
        return sum;
    }
    
    class Node{
        char[] prefixValCount = new char[26];
        int[] keys = new int[26];
        Node[] children = new Node[26];
    }

    /**
     * 递归更新 插入时prefixValCount[index] + key的val; 若果该key已存在则返回该key的旧值，递归prefixValCount - key的旧值
     * @param node
     * @param s
     * @param start
     * @param val
     * @return
     */
    private int updateTree(Node node, String s, int start, int val){
        int index = s.charAt(start) - 'a';

        // 插入key-val; 并检查是否有旧值 有则返回旧值
        if (start == (s.length() - 1)){
            int old = node.keys[index];
            node.keys[index] = val;
            node.prefixValCount[index] -= old;
            node.prefixValCount[index] += val;
            return old;
        }

        // + 新值
        node.prefixValCount[index] += val;

        if (node.children[index] == null){node.children[index] = new Node();}
        int old = updateTree(node.children[index], s, start + 1, val);

        // - 旧值
        node.prefixValCount[index] -= old;
        return old;
    }

}
