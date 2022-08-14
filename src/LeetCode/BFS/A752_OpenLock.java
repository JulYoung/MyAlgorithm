package LeetCode.BFS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class A752_OpenLock {
    public static void main(String[] args) {
        A752_OpenLock so = new A752_OpenLock();
        System.out.println(so.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
        System.out.println(so.openLock(new String[]{"8888"}, "1000"));

    }

    // 打开转盘锁
    // 0000转动一步可变为8个。[1000, 9000, 0100, ... ];
    // 那么问题可转化为以0000为跟节点，到目的节点target的层数。
    // 但是中间不能碰见deadends，因此问题转化为bfs遍历过程
    public int openLock(String[] deadends, String target) {
        // 记录deadends
        HashSet<String> set = new HashSet<>(Arrays.asList(deadends));
        // 记录已经穷举过的密码，防止走回头路
        HashSet<String> visited = new HashSet<>();
        Queue<String> que = new LinkedList<>();
        que.add("0000");
        visited.add("0000");
        int depth = 0;
        while (!que.isEmpty()) {
            int size = que.size();// 这一层元素的个数
            // 遍历这一层每个元素
            for (int i = 0; i < size; i++) {
                String cur = que.poll();
                if (target.equals(cur)) {
                    return depth;
                }
                if (set.contains(cur)) {
                    continue;
                }
                // 向队列中添加这个节点的子节点。

                for (int j = 0; j < 4; j++) {
                    String up = helper(cur, j, '+');  // 向上拨
                    if (!visited.contains(up)) {
                        que.add(up);
                        visited.add(up);
                    }
                    String down = helper(cur, j, '-');  // 向下拨
                    if (!visited.contains(down)) {
                        que.add(down);
                        visited.add(down);
                    }

                }
            }
            depth++;
        }
        return depth;
    }

    // 计算当前节点的子节点
    public String helper(String cur, int idx, char ch) {
        char[] chars = cur.toCharArray();
        if (ch == '+') {
            if (chars[idx] == '9')
                chars[idx] = '0';
            else
                chars[idx] += 1;
        }
        if (ch == '-') {
            if (chars[idx] == '0')
                chars[idx] = '9';
            else
                chars[idx] -= 1;
        }
        return new String(chars);
    }
}

