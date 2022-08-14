package JianZhiOfferCoding;

public class A58_2_ReverseLeftWords {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseLeftWords("abcdefg", 2));


    }

    // 左旋转字符串
    static class Solution {
        public String reverseLeftWords(String s, int n) {
            return s.substring(n) + s.substring(0, n);
        }
    }
}

