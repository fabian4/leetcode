//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 945 👎 0

package leetcode.editor.cn;

//螺旋矩阵 II

/**
 * @author fabian
 * @date 2023-02-17 17:22:51
 */
public class P59_SpiralMatrixIi {

    public static void main(String[] args) {
        Solution solution = new P59_SpiralMatrixIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int maxNum = n * n;
            int curNum = 1;
            int[][] matrix = new int[n][n];
            int row = 0, column = 0;
            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上
            int directionIndex = 0;
            while (curNum <= maxNum) {
                matrix[row][column] = curNum;
                curNum++;
                int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
                if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || matrix[nextRow][nextColumn] != 0) {
                    directionIndex = (directionIndex + 1) % 4; // 顺时针旋转至下一个方向
                }
                row = row + directions[directionIndex][0];
                column = column + directions[directionIndex][1];
            }
            return matrix;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}