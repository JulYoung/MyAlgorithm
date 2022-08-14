package exam.tencent;

import java.math.BigInteger;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

// 通过 80%
public class A3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(calculate(s));
    }

    public static BigInteger calculate(String s) {
        Deque<BigInteger> stack = new LinkedList<>();
        char preSign = '+';
        BigInteger num = BigInteger.ZERO;
        int n = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        BigInteger pre = BigInteger.ZERO;
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(s.charAt(i) - '0'));
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stringBuilder.append("+").append(num);
                        break;
                    case 'x':
                        stringBuilder.append("x").append(num);
                        break;
                    default:
                        int length = String.valueOf(pre).length();
                        stringBuilder.delete(stringBuilder.length() - length, stringBuilder.length());
                        stringBuilder.append(pre.or(pre.add(num)));
                }
                preSign = s.charAt(i);
                pre = num;
                num = BigInteger.ZERO;
            }
        }
        n = stringBuilder.length();
        s = stringBuilder.toString();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(s.charAt(i) - '0'));
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case 'x':
                        stack.push(stack.pop().multiply(num));
                        break;
                }
                preSign = s.charAt(i);
                num = BigInteger.ZERO;
            }
        }
        BigInteger ans = BigInteger.ZERO;
        while (!stack.isEmpty()) {
            ans = ans.add(stack.pop());
        }
        return ans;
    }
}
