package LeetCode.dp.bytedance;

public class ByteDance {

//  1、 问题描述：圆环回原点问题
//    一个环上有10个点，编号为0-9，从0点出发，每步可以顺时针到下一个点，也可以逆时针到上一个点，
//    求：经过n步又回到0点有多少种不同的走法

//  举例
//    如果n=1，则从0出发只能到1或者9，不可能回到0，共0种走法
//    如果n=2，则从0出发有4条路径:0->1->2, 0->1->0, 0->9->8, 0->9->0,其中有两条回到了0点，故一共有2种走法

//https://blog.csdn.net/hanyajun0123/article/details/84320469/?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_title~default-1.control&spm=1001.2101.3001.4242
//https://blog.csdn.net/m0_37605197/article/details/107938339
//  思路：动态规划
//    我们可以想到，再回到0点可以从右面回来，也可以从左面回来，即先到达旁边的一个点，看看有多少回来的方法
//    即可。所以运用动态规划的思想，我们可以写出递推式如下：
//
//    d(k, j) = d(k-1, j-1) + d(k-1, j+1);
//
//    d(k, j)表示从点j 走k步到达原点0的方法数，因此可以转化为他相邻的点经过k-1步回到原点的问题，这样将问题的规模
//    缩小.由于是环的问题， j-1, j+1可能会超出 0到n-1的范围，因此，我们将递推式改成如下：
//
//    d(k, j) = d(k-1, (j-1+n)%n) + d(k-1, (j+1)%n);
//    因为问题从走k步转化为走k-1步的问题，所以在写程序的时候我们就按照k从0开始递增的循环写，这样当计算第k步的

    public int GetSteps(int n, int k) {

        if (n == 0) return 1;
        //如果只有2个环，则偶数有1个方法，奇数不能到达
        if (n == 2) {
            if (k % 2 == 0) return 1;
            else return 0;
        }
        // 定义dp[i][j]: i步到达j总共有多少种走法
        int[][] dp = new int[k + 1][n];
        //0步到达0点有1种方法
        dp[0][0] = 1;
        //0步到达任意点有0种方法,可java自赋0值，可省略
        //for(int i=0;i<n;i++){
        //    dp[0][i]=0
        //}
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                //i步达到j点的问题，转化为i-1步从相邻的两个节点到达目标节点的方法数之和。
                //需要保证在0~n-1范围，故需要防止越界进行处理
                dp[i][j] = dp[i - 1][(j - 1 + n) % n] + dp[i - 1][(j + 1) % n];
            }
        }
        //这里的0对应的是回到0点，达到任意点可以通过将0改为目标点即可
        return dp[k][0];
    }
}