package JianZhiOfferCoding;

public class A64_SumNums {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    static class Solution {
        int res;

        // 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
        // 使用逻辑运算法的短路效应 + 递归
        public int sumNums(int n) {

            // 短路效应，n = 1 之后不会向下递归。
            boolean temp = n > 1 && sumNums(n - 1) > 0;

            // 计算结果
            res += n;

            return res;
        }

    }
}

