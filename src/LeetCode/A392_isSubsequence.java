package LeetCode;

// 391. 完美矩形
// https://leetcode-cn.com/problems/perfect-rectangle/
public class A392_isSubsequence {
    public static void main(String[] args) {
        A392_isSubsequence so = new A392_isSubsequence();
        boolean subsequence = so.isSubsequence("abc", "ahbgdc");
        System.out.println(subsequence);
    }



    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int i = 0;
        for (int j = 0; j < t.length(); j++) {
            if (i == s.length()) {
                break;
            }
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }

        return i == s.length();

    }
}

