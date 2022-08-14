package Algorithm;

import java.util.HashMap;
import java.util.LinkedHashSet;


class LFUCache {

    int cap;
    int minFreq;
    HashMap<Integer, Integer> keyToVal;  // 记录键-值
    HashMap<Integer, Integer> keyToFreq;  // 记录键-频率
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;  // 频率 - 键集合


    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.cap = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        // get 表示访问了一次，需要更改频率。
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (this.cap <= 0)
            return;
        // key 存在
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            // 频率++
            increaseFreq(key);
            return;
        }
        // 容量不够，移除一个
        if(this.cap <= keyToVal.size()) {
            removeMinFreq();
        }

        // 添加
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);

        this.minFreq = 1;
    }

    void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);

        freqToKeys.get(freq).remove(key);

        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());

        freqToKeys.get(freq + 1).add(key);

        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            if (freq == minFreq) {
                minFreq++;
            }
        }
    }

    void removeMinFreq() {
        LinkedHashSet<Integer> keyList = freqToKeys.get(minFreq);
        Integer deletedKey = keyList.iterator().next();
        keyList.remove(deletedKey);
        if (keyList.isEmpty()) {
            freqToKeys.remove(minFreq);
        }
        keyToVal.remove(deletedKey);
        keyToFreq.remove(deletedKey);
    }
}
