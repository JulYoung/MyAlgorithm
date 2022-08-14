package Algorithm;

/**
 * 算法的关键点有 3 个：
 *   1、用 parent 数组记录每个节点的父节点，相当于指向父节点的指针，所以 parent 数组内实际存储着一个森林（若干棵多叉树）。
 *   2、用 size 数组记录着每棵树的重量，目的是让 union 后树依然拥有平衡性，而不会退化成链表，影响操作效率。
 *   3、在 find 函数中进行路径压缩，保证任意树的高度保持在常数，使得 union 和 connected API 时间复杂度为 O(1)。
 */

class UnionFind {
    // 连通分量个数
    private int count;
    // 存储一棵树
    private int[] parent;
    // 记录树的“重量” ，用于平衡性优化
    private int[] size;

    public UnionFind(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;  //  父节点指针初始指向自己
            size[i] = 1;
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return;

        // 小树接到大树下面，较平衡
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    /* 查找x的根节点 */
    private int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];  // 进行路径压缩
            x = parent[x];
        }
        return x;
    }

    public boolean isConnected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    public int count() {
        return count;
    }
}
