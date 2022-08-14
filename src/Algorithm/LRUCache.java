package Algorithm;

import java.util.LinkedHashMap;

/**
 *  使用 LinkedHashMap 实现LRU机制。
 *      1. LinkedHashMap：HashMap底层，并将每个节点组成队列形式，head和tail
 *      2. get()
 *      3. put()
 *      4. makeRecently()
 */
class LRUCache {
    int cap;  // 容量
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        // 将 key 变为最近使用
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            // 修改 key 的值
            cache.put(key, val);
            // 将 key 变为最近使用
            makeRecently(key);
            return;
        }

        // 超出缓存容量，移除最久未使用。
        if (cache.size() >= this.cap) {
            // 链表头部就是最久未使用的 key
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        // 将新的 key 添加链表尾部
        cache.put(key, val);
    }

    private void makeRecently(int key) {
        int val = cache.get(key);
        // 删除 key，重新插入到队尾
        cache.remove(key);  // 队列，头删
        cache.put(key, val);  // 尾插
    }
}
