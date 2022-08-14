package LeetCode.binarytree;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

// 将二叉树的每一层的节点连接起来
public class A116_Connect {
    public static void main(String[] args) {

    }

    public Node connect(Node root) {

        dfs(root);
        return root;
    }

    void dfs(Node root) {
        if (root == null)
            return;
        Node left = root.left;
        Node right = root.right;

        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }

        // 递归
        dfs(root.left);
        dfs(root.right);

    }
}
