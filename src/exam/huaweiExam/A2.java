package exam.huaweiExam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class A2 {
    public static void main(String[] args) {
        // 输入
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] speeds = new int[n];
        for (int i = 0; i < n; i++) {
            speeds[i] = scanner.nextInt();
        }

        int aebNum = 0;
        int curTime = 0;  // 改变题，1s
        int start = 0;  // 开始上传和结束上传的索引
        int end;

        ArrayList<Integer> res = new ArrayList<>();
        res.add(speeds[0]);

        HashSet<List<Integer>> hashSet = new HashSet<>();
        for (int i = 1; i < speeds.length; i++) {
            curTime++;  // 时间加1

            // 进入aeb状态
            if (speeds[i - 1] - speeds[i] >= 9) {
                if (aebNum == 0) {
                    start = Math.max(i - 4, 0);
                }
                aebNum++;
                if (aebNum >= 4) {
                    curTime = 0;
                }
            } else {  // 没有进入AEB
                if (aebNum >= 4) {
                    ArrayList<Integer> integers = new ArrayList<>();
                    end = i;
                    end = Math.min(end + 4, speeds.length);
                    for (int j = start; j < end; j++) {
                        integers.add(speeds[j]);
                    }
                    curTime = 0;
                    if (hashSet.add(integers)) {
                        res.addAll(integers);
                    }
                }
                aebNum = 0;
            }
            if (curTime == 60) {
                res.add(speeds[i]);
                curTime = 0;
            }
        }
        // 输出
        for (int i = 0; i < res.size() - 1; i++) {
            System.out.print(res.get(i) + ",");
        }
        System.out.print(res.get(res.size() - 1));


    }

}
