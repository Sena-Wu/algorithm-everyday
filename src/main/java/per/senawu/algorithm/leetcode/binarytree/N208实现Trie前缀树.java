package per.senawu.algorithm.leetcode.binarytree;

import java.util.HashMap;

/**
 * @author Sena-wu
 * @date 2022/6/13
 */

/**
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 *
 * 请你实现 Trie 类：
 *
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串  word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 *
 * 链接：https://leetcode.cn/problems/implement-trie-prefix-tree
 */

/**
 * 采用多叉树结构,用来记录字符串前缀; 树的查找路径代表字符串的前缀; 树的任一节点内的元素个数是有序的
 *
 * 树的节点结构：
 *      class Node {
 *         boolean[] character = new boolean[26];
 *         // key为character的某个index, child.get(index)表示第index个字符的子节点
 *         HashMap<Integer, Node> child = new HashMap<>();
 *         // 是否存在该字符串 isEnd == false则只是前缀 isEnd == true 存在该字符串
 *         boolean[] isEnd = new boolean[26];
 *      }
 */
public class N208实现Trie前缀树 {
    private Node root = null;

    public N208实现Trie前缀树() {
        root = new Node();
    }

    public void insert(String word) {
        Node work = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            int index = word.charAt(0);
            work.character[index] = true;
            if (!work.child.containsKey(index)) {
                work.child.put(index, new Node());
            }
            if (i == len - 1) {
                work.isEnd[index] = true;
                return;
            }
            work = work.child.get(index);
        }
    }

    // 错判对
    public boolean search(String word) {
        Node work = root;
        int index;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            index = word.charAt(i) - 'a';
            if (work.character[index] == false) {
                return false;
            }
            if (i == (len - 1) && work.isEnd[index] == true) {
                return true;
            }
            work = work.child.get(index);

        }
        return false;
    }

    public boolean startsWith(String prefix) {
        Node work = root;
        int index;
        int len = prefix.length();
        for (int i = 0; i < len; i++) {
            index = prefix.charAt(i) - 'a';
            if (work.character[index] == false) {
                return false;
            }
            work = work.child.get(index);

        }
        return true;
    }

    class Node {
        boolean[] character = new boolean[26];
        HashMap<Integer, Node> child = new HashMap<>();
        // 是否存在该字符串 isEnd == false则只是前缀 isEnd == true 存在该字符串
        boolean[] isEnd = new boolean[26];
    }
}
