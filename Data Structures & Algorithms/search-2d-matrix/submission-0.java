class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length * matrix[0].length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if(matrix[mid/matrix[0].length][mid%matrix[0].length] == target) {
                return true;
            }
            if(matrix[mid/matrix[0].length][mid%matrix[0].length] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
// 0 0-3
// 1 0-3
// 2 0-3

