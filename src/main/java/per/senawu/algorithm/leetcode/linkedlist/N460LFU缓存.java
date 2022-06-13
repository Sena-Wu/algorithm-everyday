package per.senawu.algorithm.leetcode.linkedlist;

/**
 * @author Sena-wu
 * @date 2022/6/13
 * <p>
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
 * <p>
 * 实现 LFUCache 类：
 * <p>
 * LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
 * int get(int key) - 如果键 key 存在于缓存中，则获取键的值，否则返回 -1 。
 * void put(int key, int value) - 如果键 key 已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量 capacity 时，则应该在插入新项之前，移除最不经常使用的项。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。
 * 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。
 * <p>
 * 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
 * <p>
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 * 链接：https://leetcode.cn/problems/lfu-cache
 * <p>
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
 * <p>
 * 实现 LFUCache 类：
 * <p>
 * LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
 * int get(int key) - 如果键 key 存在于缓存中，则获取键的值，否则返回 -1 。
 * void put(int key, int value) - 如果键 key 已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量 capacity 时，则应该在插入新项之前，移除最不经常使用的项。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。
 * 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。
 * <p>
 * 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
 * <p>
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 * 链接：https://leetcode.cn/problems/lfu-cache
 */

/**
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
 *
 * 实现 LFUCache 类：
 *
 * LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
 * int get(int key) - 如果键 key 存在于缓存中，则获取键的值，否则返回 -1 。
 * void put(int key, int value) - 如果键 key 已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量 capacity 时，则应该在插入新项之前，移除最不经常使用的项。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。
 * 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。
 *
 * 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
 *
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * 链接：https://leetcode.cn/problems/lfu-cache
 */

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * 为实现O(1) 的平均时间复杂度，需要有：
 *      minFreq记录最小频率值
 *      hashmap保存key-value实现O(1)读取
 *      hashmap保存key-freq实现O(1)修改freq
 *      hashmap<int, linkedHashSet>保存freq-keyList实现O(1)查找满足移除条件的key
 */
public class N460LFU缓存 {
    private int maxCapacity = 0, minFreq = 1;
    private HashMap<Integer, Integer> keyToVal = new HashMap<>();
    private HashMap<Integer, Integer> keyToFreq = new HashMap<>();
    private HashMap<Integer, LinkedHashSet<Integer>> freqTokeys = new HashMap<>();

    public N460LFU缓存(int capacity) {
        this.maxCapacity = capacity;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        // 更新key的freq
        addFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            addFreq(key);
            return;
        }
        if (maxCapacity > 0) {
            if (keyToVal.size() >= maxCapacity) {
                removeMinFreq();
            }
            keyToVal.put(key, value);
            // 记录新元素freq
            addNew(key);
        }

    }

    /**
     * 记录新元素freq
     */
    private void addNew(int key) {
        keyToFreq.put(key, 1);
        if (!freqTokeys.containsKey(1)) {
            freqTokeys.put(1, new LinkedHashSet<>());
        }
        freqTokeys.get(1).add(key);
        minFreq = 1;
    }

    /**
     * 更新存在元素freq
     */
    private void addFreq(int key) {
        Integer oldFreq = keyToFreq.remove(key);
        // key的freq + 1
        keyToFreq.put(key, oldFreq + 1);
        // 把key从oldFreq集合中移除
        if (freqTokeys.containsKey(oldFreq)) {
            freqTokeys.get(oldFreq).remove(key);
            // 访问的key是否是minFreq列表中最后一个元素 ？ 是则更新minFreq
            if (freqTokeys.get(oldFreq).size() == 0) {
                freqTokeys.remove(oldFreq);
                if (minFreq == oldFreq) {
                    minFreq += 1;
                }
            }
        }
        if (!freqTokeys.containsKey(oldFreq + 1)) {
            freqTokeys.put(oldFreq + 1, new LinkedHashSet<>());
        }
        // 把key添加至oldFreq + 1集合中
        freqTokeys.get(oldFreq + 1).add(key);
    }

    private void removeMinFreq() {
        if (freqTokeys.containsKey(minFreq)) {
            Integer old = freqTokeys.get(minFreq).iterator().next();
            freqTokeys.get(minFreq).remove(old);
            // minFreq不用更新 因为这个方法在新增新元素时被调用，后续调用addNew方法中会把minfreq置为1
            if (minFreq != 1 && freqTokeys.get(minFreq).size() == 0) {
                freqTokeys.remove(minFreq);
            }
            keyToVal.remove(old);
            keyToFreq.remove(old);
        }
    }
}
