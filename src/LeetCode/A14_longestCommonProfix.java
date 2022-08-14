package LeetCode;

public class A14_longestCommonProfix {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String str = "123456";
        System.out.println(str.substring(0, -1));

    }

    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) return "";
            if (strs.length == 1) return strs[0];
            int idx = -1;
            for (int i = 0; i < strs[0].length(); i++) {
                for (int j = 1; j < strs.length; j++) {

                    if (strs[j].length()-1 < i || strs[0].charAt(i) != strs[j].charAt(i)) {
                        idx = i;
                        break;
                    }
                }
                if (idx != -1) {
                    break;
                }
            }
            if (idx == -1) {
                return strs[0];
            } else {
                return strs[0].substring(0, idx);
            }
        }
    }

}

