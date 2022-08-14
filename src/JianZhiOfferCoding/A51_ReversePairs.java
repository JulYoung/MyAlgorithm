package JianZhiOfferCoding;

public class A51_ReversePairs {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reversePairs(new int[]{7, 5, 6, 4}));
    }

    static class Solution {
        int count = 0;
        int[] temp;

        public int reversePairs(int[] nums) {
            temp = new int[nums.length];
            sort(nums, 0, nums.length - 1);
            return count;
        }

        public void sort(int[] arr, int l, int r) {
            if (l < r) {
                int mid = (l + r) / 2;
                sort(arr, l, mid);
                sort(arr, mid + 1, r);
                merge(arr, l, mid, r);
            }
        }

        public void merge(int[] arr, int l, int m, int r) {

            int i = l;
            int j = m + 1;
            int t = 0;
            while (i <= m && j <= r) {
                if (arr[i] <= arr[j]) {
                   temp[t++] = arr[i++];
                } else {
                    count += m - i + 1;
                    temp[t++] = arr[j++];
                }
            }
            while (i <= m) {
                temp[t++] = arr[i++];
            }
            while (j <= r) {
                temp[t++] = arr[j++];
            }

            t = 0;
            for (int k = l; k <= r; k++) {
                arr[k] = temp[t++];
            }
        }
    }
}

