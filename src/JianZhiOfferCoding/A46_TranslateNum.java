package JianZhiOfferCoding;

// 把数字翻译成字符串
public class A46_TranslateNum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.translateNum(12258));

    }

    // 动态规划
    // 时间：N
    // 空间：N
    static class Solution {
        public int translateNum(int num) {
            String s = Integer.toString(num);
            int a = 1;
            int b = 1;
            for (int i = 2; i <= s.length(); i++) {
                int c = 0;
                String sub = s.substring(i - 2, i);
                if (sub.compareTo("10") >= 0 && sub.compareTo("25") <= 0) {
                    c = a + b;
                } else
                    c = b;
                a = b;
                b = c;
            }
            return b;
        }
    }
}


