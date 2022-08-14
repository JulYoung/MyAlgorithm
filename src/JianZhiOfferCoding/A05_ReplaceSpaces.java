package JianZhiOfferCoding;

public class A05_ReplaceSpaces {

    public static void main(String[] args) {
        String str = "We are happy";
        Solution solution = new Solution();
        System.out.println(solution.replaceSpaces(str));

    }

    static class Solution {
        public String replaceSpaces(String str) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != ' ') {
                    res.append(str.charAt(i));
                } else {
                    res.append("%20");
                }
            }

            return res.toString();
        }
    }

}

