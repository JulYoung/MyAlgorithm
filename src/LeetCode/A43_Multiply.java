package LeetCode;

public class A43_Multiply {
    public static void main(String[] args) {
        A43_Multiply so = new A43_Multiply();
        System.out.println(so.multiply("123", "456"));
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int n = num1.length() + num2.length();
        int[] res = new int[n];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + res[i + j + 1];
                res[i + j] += sum / 10; // 十位
                res[i + j + 1] = sum % 10; // 个位
            }
        }
        StringBuilder builder = new StringBuilder();
        int idx = 0;
        while (res[idx] == 0) {
           idx++;
        }
        for (int i = idx; i < n; i++) {
            builder.append(res[i]);
        }
        return builder.toString();
    }

}

