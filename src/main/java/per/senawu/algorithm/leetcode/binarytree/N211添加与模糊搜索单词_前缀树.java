package per.senawu.algorithm.leetcode.binarytree;

/**
 * @author Sena-wu
 * @date 2022/6/16
 */

/**
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *
 * 实现词典类 WordDictionary ：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 *
 * 链接：https://leetcode.cn/problems/design-add-and-search-words-data-structure
 */

/**
 * 节点结构：
 *      class Node{
 *         boolean[] character = new boolean[26];  // 该数组可以去除, 仅通过children[index] 是否为null则可以判断未去除character数组时character[index]的值是否为true
 *         boolean[] isEnd = new boolean[26];
 *         boolean like = false;  // 模糊匹配 该节点是否有插入值 省去遍历isEnd的步骤
 *         Node[] children = new Node[26];
 *     }
 * 向下搜索, 遇到'.'模糊匹配遍历搜索所有子节点
 */
public class N211添加与模糊搜索单词_前缀树 {
    private Node root = new Node();
    public N211添加与模糊搜索单词_前缀树() {
    }

    public void addWord(String word) {
        Node work = root;
        int index = 0;
        for (int i = 0; i < word.length(); i++){
            index = word.charAt(i) - 'a';
            work.character[index] = true;
            if (i == word.length() - 1){
                work.isEnd[index] = true;
                work.like = true;
                return;
            }
            if (work.children[index] == null){work.children[index] = new Node();}
            work = work.children[index];
        }
    }

    public boolean search(String word) {
        return searchLike(root, word, 0);
    }

    private boolean searchLike(Node work, String s, int start){
        char c = s.charAt(start);
        int index = c - 'a';


        if (start == s.length() - 1){
            if ('.' == c){
                return work != null && work.like;
            }else{
                return work != null && work.isEnd[index];
            }
        }

        if ('.' == c){
            return work != null && searchLikeFor(work, s, start);
        }else{
            return work != null && searchLike(work.children[index], s, start + 1);
        }

    }

    private boolean searchLikeFor(Node work, String s, int start){
        for (int i = 0; i < 26; i++){
            if (searchLike(work.children[i], s, start + 1) == true){
                return true;
            }
        }
        return false;
    }

    class Node{
        boolean[] character = new boolean[26];
        boolean[] isEnd = new boolean[26];
        boolean like = false;  // 模糊匹配 该节点是否有插入值
        Node[] children = new Node[26];
    }
}
