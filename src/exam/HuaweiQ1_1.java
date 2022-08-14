package exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HuaweiQ1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int startTime, endTime, startStation, endStation, path;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < K; i++) {
            startTime = scanner.nextInt();
            startStation = scanner.nextInt();
            endStation = scanner.nextInt();
            if (startStation == endStation) {
                continue;
            }
            path = Math.abs(endStation - startStation);
            path = (path > (N >> 1) ? N - path : path);
            endTime = startTime + path * 5;

            map.put(startTime, 1);
            map2.put(endTime, 2);
            list.add(startTime);
            list.add(endTime);
        }
        list.sort(((o1, o2) -> o1 - o2));
        System.out.println(list);
        int a = 0;
        for (Integer integer : list) {
            if (map.containsKey(integer)) {
                a++;
            }
            if (map2.containsKey(integer)) {
                a--;
            }
            res = Math.max(res, a);
        }
        System.out.println(res);
    }
}
