package LeetCode;

import java.util.HashSet;

// 391. 完美矩形
// https://leetcode-cn.com/problems/perfect-rectangle/
public class A391_IsRectangleCover {
    public static void main(String[] args) {
        A391_IsRectangleCover so = new A391_IsRectangleCover();
        int[][] rec = new int[][]{{1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}};
        System.out.println(so.isRectangleCover(rec));
    }

    // 从面积和顶点两方面考虑
    //     面积：每个小矩形的面积之和 = 完美矩形的面积之和
    //     顶点：仅存在4个顶点 && 这4个顶点与完美矩形四个顶点一致
    // https://labuladong.gitbook.io/algo/mu-lu-ye-4/wan-mei-ju-xing
    public boolean isRectangleCover(int[][] rectangles) {
        int X1 = Integer.MAX_VALUE, Y1 = Integer.MAX_VALUE;
        int X2 = Integer.MIN_VALUE, Y2 = Integer.MIN_VALUE;

        int areas = 0;
        HashSet<String> set = new HashSet<>();
        for (int[] rectangle : rectangles) {
            int x1 = rectangle[0], y1 = rectangle[1];
            int x2 = rectangle[2], y2 = rectangle[3];
            // 更新完美矩形的坐标
            X1 = Math.min(X1, x1);
            Y1 = Math.min(Y1, y1);
            X2 = Math.max(X2, x2);
            Y2 = Math.max(Y2, y2);
            // 计算小矩形的面积和
            areas += (x2 - x1) * (y2 - y1);
            // 计算最后存在的顶点
            String[] p = {x1 + " " + y1, x1 + " " + y2, x2 + " " + y1, x2 + " " + y2};
            for (String s : p) {
                if (set.contains(s)) {
                    set.remove(s);
                } else {
                    set.add(s);
                }
            }
        }
        // 最终面积不相等，返回false
        if (areas != (X2 - X1) * (Y2 - Y1))
            return false;
        // 最终顶点数不等于4，放回false
        if (set.size() != 4)
            return false;
        // (X1, Y1)(X2, Y2)在最终顶点集合中
        if (!set.contains(X1 + " " + Y1) || !set.contains(X2 + " " + Y2)) {
            return false;
        }
        return true;
    }
}

