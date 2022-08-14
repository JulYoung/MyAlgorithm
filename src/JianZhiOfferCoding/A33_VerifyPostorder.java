package JianZhiOfferCoding;

import java.util.Stack;

//
public class A33_VerifyPostorder {
    public static void main(String[] args) {

    }
    // 优解：利用单调栈求解  时间：n  空间：n
    // 1. 借助一个单调栈 stack 存储值递增的节点；
    // 2. 每当遇到值递减的节点,则通过出栈来更新节点的父节点
    // 3. 每轮判断当前节点与父节点的值的关系
    //      1. 当前值 > root.val  , return false;
    //      2. 当前值 < root.val  , 继续判断
    public boolean verifyPostorder2(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) return false;
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }

    // 递归分治法
    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }

    public boolean helper(int[] postorder, int i, int j) {
        if (i >= j)
            return true;
        int p = i;
        // 找第一个大于当前树的根节点的节点，后面则是右子树
        while (postorder[p] < postorder[j]) {
            p++;
        }
        // 判断[p,j)范围的节点值是否全部大于根节点
        int m = p;
        while (postorder[m] > postorder[j]) {
            m++;
        }
        if (m == j) {  // 当前树符合二叉搜索树的定义，继续判断左右子树
            return helper(postorder, i, p - 1) && helper(postorder, p, j - 1);
        } else
            return false;
    }


}