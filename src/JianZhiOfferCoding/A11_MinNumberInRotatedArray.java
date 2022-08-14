package JianZhiOfferCoding;

// 旋转数组的最小数字
public class A11_MinNumberInRotatedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num = {3,4,5,1,2};
        System.out.println(solution.minArray(num));

    }


    // 二分法，两种情况
    //     无重复数字
    //     有重复数字
    static class Solution {
        public int minArray(int[] numbers) {

            int left = 0;
            int right = numbers.length - 1;
            int mid = left;
            while (left < right) {
                mid = left + (right - left) / 2;

                if (numbers[mid] < numbers[right]) {
                    right = mid;
                } else if (numbers[mid] > numbers[right]) {
                    left = mid + 1;
                } else {  // 有重复数字的情况，中间与后面相等，无法判断
                    right--;
                }
            }
            return numbers[left];
        }
    }
}

