package per.senawu.algorithm.leetcode.linkedlist;

/**
 * @author Sena-wu
 * @date 2022/6/13
 */

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * 链接：https://leetcode.cn/problems/lru-cache
 */

import java.util.LinkedHashMap;

/**
 * hash + 双向链表
 * hash来实现O(1)的元素查找定位
 * 双向链表实现O(1)的元素插入与删除
 * 列表尾部维持最近访问或插入的数据：插入时向链表尾部插入并在hash中记录key-node映射, get读取节点数据后将该节点移动至链表尾部
 * 当链表中容量超出后从链表头部删除数据 同时也删除hash中的对应记录
 */
public class N146LRU缓存 {
    private int maxCapacity = 0;
    private LinkedHashMap<Integer, Integer> cache = new LinkedHashMap();
    public N146LRU缓存(int capacity) {
        this.maxCapacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)){
            return -1;
        }
        makeRecent(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        // key 存在 先修改后更新至尾部
        if (cache.containsKey(key)){
            cache.put(key, value);
            makeRecent(key);
            return;
        }
        // 不存在检查是否超出最大容量
        if (cache.size() >= maxCapacity){
            Integer oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        cache.put(key, value);
    }

    private void makeRecent(int key){
        Integer val = cache.remove(key);
        cache.put(key, val);
    }
}
