package LeetCode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class A380_RandomizedSet {

    ArrayList<Integer> arr;
    HashMap<Integer, Integer> valToIdx;
    /** Initialize your data structure here. */
    public A380_RandomizedSet() {
        arr = new ArrayList<>();
        valToIdx = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valToIdx.containsKey(val)) {
            return false;
        }
        valToIdx.put(val, arr.size());
        arr.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!valToIdx.containsKey(val)) {
            return false;
        }
        // 交换idx和末尾元素
        int idx = valToIdx.get(val);
        int temp = arr.get(idx);
        int size = arr.size();
        arr.set(idx, arr.get(size - 1));
        arr.set(size - 1, temp);

        valToIdx.put(arr.get(idx), idx);  // 更新末尾元素索引
        valToIdx.remove(temp);  // 移除val

        arr.remove(size - 1);  // 移除末尾
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int idx = random.nextInt(arr.size());
        return arr.get(idx);
    }
}

