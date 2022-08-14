package JianZhiOfferCoding;

import base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//
public class A37_SerializeAndDeserialize {
    public static void main(String[] args) {

    }
    // 利用层序遍历
    public String serialize(TreeNode root) {
        if (root == null) return null;
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            if (cur != null) {
                res.append(cur.val).append(",");
                que.add(cur.left);
                que.add(cur.right);
            }else {
                res.append("#,"); // 代表null
            }
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null)
            return null;
        String[] split = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int i = 1; // split数组的索引
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            if (!split[i].equals("#")) {
                cur.left = new TreeNode(Integer.parseInt(split[i]));
                que.add(cur.left);
            }
            i++;
            if (!split[i].equals("#")) {
                cur.right = new TreeNode(Integer.parseInt(split[i]));
                que.add(cur.right);
            }
            i++;
        }
        return root;
    }
}


