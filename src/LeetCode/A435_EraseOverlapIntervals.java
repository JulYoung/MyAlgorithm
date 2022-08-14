package LeetCode;


import java.util.Arrays;

public class A435_EraseOverlapIntervals {
    public static void main(String[] args) {
        A435_EraseOverlapIntervals so = new A435_EraseOverlapIntervals();
        int i = so.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}});
        System.out.println(i);
    }


    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, ((o1, o2) -> o1[1] - o2[1]));

        int end = intervals[0][1];
        int cnt = 1;
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            if (start >= end) {
                cnt++;
                end = intervals[i][1];
            }
        }
        return intervals.length - cnt;
    }
}

