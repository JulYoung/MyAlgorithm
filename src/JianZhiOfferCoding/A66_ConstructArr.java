package JianZhiOfferCoding;

import java.util.Arrays;

public class A66_ConstructArr {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[] constructArr2(int[] a) {
            if (a.length == 0) return new int[0];
            int[] b = new int[a.length];
            int temp = a[0];
            b[0] = 1;
            for (int i = 1; i < b.length; i++) {
                b[i] = temp;
                temp = temp * a[i];
            }
            System.out.println(Arrays.toString(b));

            temp = a[a.length - 1];
            for (int i = a.length - 2; i >= 0 ; i--) {
                b[i] *= temp;
                temp = temp * a[i];
            }
            System.out.println(Arrays.toString(b));
            return b;
        }

        public int[] constructArr(int[] a) {
            if (a.length == 0) return new int[0];

            int[] b = new int[a.length];

            b[0] = 1;
            for (int i = 1; i < a.length; i++) {
                b[i] = b[i - 1] * a[i - 1];
            }
            int temp = 1;  // 记录后面的乘积
            for (int i = a.length - 1; i >= 0; i--) {
                b[i] = b[i] * temp;

                temp *= a[i];
            }

            return b;
        }
    }
}

