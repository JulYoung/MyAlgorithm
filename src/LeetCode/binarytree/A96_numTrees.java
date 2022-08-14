package LeetCode.binarytree;

public class A96_numTrees {
    public static void main(String[] args) {

    }

    // 动态规划
    // 对于1 ... j ... n, 以 i 为根节点，那么此时有[1 ... (j - 1)]在左子树，[(j + 1) ... n] 在右子树
    // 那么 dp[i] += dp[j - 1] * dp[i - j]
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}

