package LeetCode.binarytree;

import base.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class A652_FindDuplicateSubtrees {
    public static void main(String[] args) {

    }

    // 寻找重复的子树
    // 核心为序列化子树(后序遍历)，在map中存储每个子树。
    HashMap<String, Integer> map;
    List<TreeNode> list;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        find(root);
        return list;
    }
    public String find(TreeNode root) {
        if (root == null) {
            return "#";  // 代表节点为空
        }
        // 后序遍历框架
        String left = find(root.left);
        String right = find(root.right);

        // 利用后序遍历规则，序列化子树，成一个字符串
        String subtree = left + "," + right + "," + root.val;

        int freq = map.getOrDefault(subtree, 0);
        if (freq == 1) {
            list.add(root);
        }
        map.put(subtree, freq + 1);
        return subtree;
    }

}

