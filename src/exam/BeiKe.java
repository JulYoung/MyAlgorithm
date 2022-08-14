package exam;

import base.TreeNode;

import java.util.*;

// 贝壳笔试题
public class BeiKe {
    public static void main(String[] args) {
        BeiKe so = new BeiKe();
        long section = so.section(new int[]{2, 4, 8}, 6);
        System.out.println(section);
    }
    /** 第一题 */
    public long[] FarmerNN (int n, long m) {
        // write code here
        long[] arr = new long[n];
        long a = m / (n - 1);
        long b = m % (n - 1);
        Arrays.fill(arr, a);
        if(a % 2 == 0) {  // 偶数
            arr[0] /=  2;
            arr[n - 1] /= 2;
            for(int i = 0; i < b; i++) {
                arr[i]++;
            }
        } else {  // 奇数
            arr[0] /= 2;
            arr[0]++;
            arr[n - 1] /= 2;
            for(int i = 0; i < b; i++) {
                arr[n - 1 - i]++;
            }
        }
        return arr;
    }
    /** 第二题 */
    public String NS_String(String s, int k) {
        // write code here
        char[] chs = s.toCharArray();
        int n = chs.length;
        Map<Character, Set<Integer>> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(chs[i])) {
                Set<Integer> set = new HashSet<>();
                set.add(i);
                map.put(chs[i], set);
            } else {
                Set<Integer> list = map.get(chs[i]);
                list.add(i);
            }
        }
        HashSet<Integer> set = new HashSet<>();
        Iterator<Map.Entry<Character, Set<Integer>>> iterator = map.entrySet().iterator();
        for (int i = 0; i < k && iterator.hasNext(); i++) {
            set.addAll(iterator.next().getValue());
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                ans.append(chs[i]);
            }
        }
        return ans.toString();
    }

    /** 第三题 */
    public long section(int[] a, int t) {
        // write code here
        int n = a.length;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(a[0], 0);
        long flag = -1;
        for (int i = 0; i < n; i++) {
            int temp = t ^ a[i];
            if (!map.containsKey(temp)) {
                res += i - flag - 1;
            } else {
                flag = Math.max(flag, map.get(temp));
                res += i - flag - 1;
            }
            map.put(a[i], i);
        }
        return res;
    }

    /** 第四题 */
    int max = Integer.MIN_VALUE;
    HashSet<String> set = new HashSet<>();
    public int maxSubTree(TreeNode root) {
        // write code here
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;
        String lookup = lookup(root);
        return max;
    }
    public String lookup(TreeNode node) {
        if (node == null) {
            return "#";
        }
        String subTree = node.val + "," + lookup(node.left) + "," + lookup(node.right);
        if (set.contains(subTree)) {
            String[] split = subTree.split(",");
            int n = 0;
            for (String s : split) {
                if (!s.equals("#")) {
                    n++;
                }
            }
            max = Math.max(max, n);
        } else {
            set.add(subTree);
        }
        return subTree;
    }
}
