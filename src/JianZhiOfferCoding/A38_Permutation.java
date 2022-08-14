package JianZhiOfferCoding;

import java.util.*;

// 字符串的全排列
public class A38_Permutation {
    public static void main(String[] args) {
        A38_Permutation so = new A38_Permutation();
        System.out.println(Arrays.toString(so.permutation("abc")));
    }
    // dfs + 回溯
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    boolean[] used;
    public String[] permutation(String s) {
        used = new boolean[s.length()];
        dfs(s.toCharArray());
        return res.toArray(new String[0]);
    }
    void dfs(char[] chs) {
        // 结束条件
        if (path.length() == chs.length){
            res.add(new String(path));
        }

        // 选择列表
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chs.length; i++) {
            if (used[i])
                continue;
            if (set.contains(chs[i]))  // 剪枝
                continue;
            path.append(chs[i]);
            used[i] = true;
            set.add(chs[i]);
            dfs(chs);
            // 回溯
            path.deleteCharAt(path.length() - 1);
            used[i] = false;
        }
    }

    static class Solution {
        ArrayList<String> res = new ArrayList<>();
        char[] c;

        // 字符串的全排列
        public String[] permutation(String s) {
            c = s.toCharArray();
            dfs(0);

            // toArray: 将ArrayList对象转换为数组类型
            // 参数: 只表示类型，所以可以传递一个长度为0的数组
            // 返回：返回一个参数类型的数组。
            return res.toArray(new String[0]);
        }

        public void dfs(int x) {  // 固定第 x 位

            // 递归终止条件
            if (x == c.length - 1) {
                res.add(String.valueOf(c));
                return;
            }

            HashSet<Character> set = new HashSet<>();
            for (int i = x; i < c.length; i++) {
                // 剪枝，相同元素不用交换
                if (set.contains(c[i])) continue;

                set.add(c[i]);
                // 交换
                swap(x, i);

                // 交换后继续向下递归，固定 x+1 位
                dfs(x + 1);

                // 恢复交换
                swap(x, i);
            }
        }

        public void swap(int x, int i) {
            if (x != i) {
                char temp = c[x];
                c[x] = c[i];
                c[i] = temp;
            }
        }
    }

}


