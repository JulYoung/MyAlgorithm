package LeetCode;


import java.util.Arrays;
import java.util.Comparator;

public class A1024_VideoStitching {
    public static void main(String[] args) {
        A1024_VideoStitching so = new A1024_VideoStitching();

    }


    public int videoStitching(int[][] clips, int time) {
        // 按起点升序排序
        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int i = 0, res = 0;
        int curEnd = 0, nextEnd = 0;
        int len = clips.length;
        // 起点必须小于等于上一个的终点才能连上
        while (i < len && clips[i][0] <= curEnd) {
            // 在起点小于上一个终点的情况下找最大的终点
            while (i < len && clips[i][0] <= curEnd) {
                nextEnd = Math.max(nextEnd, clips[i][1]);
                i++;
            }
            res++;
            curEnd = nextEnd;
            if (curEnd >= time) {
                return res;
            }
        }
        return -1;
    }
}

