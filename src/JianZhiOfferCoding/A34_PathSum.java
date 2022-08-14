package JianZhiOfferCoding;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//
public class A34_PathSum {
    public static void main(String[] args) {

    }

    List<List<Integer>> res = new ArrayList<>();
    Stack<Integer> path = new Stack<>();
    int sum = 0;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return res;
    }
    public void dfs(TreeNode root, int target) {
        if (root == null) return;

        path.add(root.val);
        sum += root.val;
        if (root.left == null && root.right == null) {
            if (sum == target) {
                res.add(new ArrayList<>(path));
            }
        }
        dfs(root.left, target);
        dfs(root.right, target);
        // 回溯
        path.pop();
        sum -= root.val;
    }
}

