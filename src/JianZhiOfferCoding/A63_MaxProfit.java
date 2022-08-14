package JianZhiOfferCoding;

// 股票的最大利润
public class A63_MaxProfit {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int maxProfit = solution.maxProfit(new int[]{7,6,4,3,1});
        System.out.println("maxProfit = " + maxProfit);


    }

    static class Solution {
        public int maxProfit(int[] prices) {

            int min = Integer.MAX_VALUE;
            int res = 0;

            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < min) {
                    min = prices[i];
                } else {
                    res = Math.max(res, prices[i] - min);
                }

            }
            return res;
        }

    }
}

