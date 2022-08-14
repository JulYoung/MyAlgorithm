package LeetCode;

import java.util.Arrays;


public class A1109_corpFlightBookings {
    public static void main(String[] args) {
        A1109_corpFlightBookings so = new A1109_corpFlightBookings();
        int[] ints = so.corpFlightBookings(new int[][]{{3, 3, 5}, {1, 3, 20}, {1, 2, 15}}, 3);
        System.out.println(Arrays.toString(ints));
    }

    // 差分数组
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // 构建差分数组
        int len = bookings.length;
        int[] diff = new int[n + 1];

        for (int i = 0; i < bookings.length; i++) {
            int start = bookings[i][0];
            int end = bookings[i][1];
            diff[start - 1] += bookings[i][2];
            diff[end] -= bookings[i][2];
        }

        int[] res = new int[n];
        res[0] = diff[0];
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }

}

