package JianZhiOfferCoding;

public class A04_FindNumberIn2DArray {

    public static void main(String[] args) {
        A04_FindNumberIn2DArray so = new A04_FindNumberIn2DArray();
        System.out.println(so.findNumberIn2DArray(new int[0][0], 0));
    }

    // 二维数组中的查找,每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target < matrix[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}

