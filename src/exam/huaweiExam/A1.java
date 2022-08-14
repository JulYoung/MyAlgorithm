package exam.huaweiExam;

import java.util.Scanner;
import java.util.Stack;

// 反转括号中的元素
public class A1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        char[] chars = str.toCharArray();

        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (char c : chars) {
            if (c == '(') {
                stack.push(new StringBuilder(stringBuilder));
                stringBuilder.delete(0, stringBuilder.length());
            } else if (c == ')') {
                stringBuilder.reverse();
                stringBuilder = stack.pop().append(stringBuilder);
            } else {
                stringBuilder.append(c);
            }
        }
        System.out.println(stringBuilder);
    }
}
