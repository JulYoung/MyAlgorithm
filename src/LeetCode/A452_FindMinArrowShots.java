package LeetCode;


import java.util.Arrays;

public class A452_FindMinArrowShots {
    public static void main(String[] args) {
        A452_FindMinArrowShots so = new A452_FindMinArrowShots();
        int minArrowShots = so.findMinArrowShots(new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}});
        System.out.println(minArrowShots);
    }

    // 实质求不相交区间数
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, ((o1, o2) -> o1[1] < o2[1] ? -1 : 1));

        long end = points[0][1];
        int cnt = 1;
        for (int i = 1; i < points.length; i++) {
            long start = points[i][0];
            if (start > end) {
                cnt++;
                end = points[i][1];
            }
        }
        return cnt;
    }
}

