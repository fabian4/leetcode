//给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0
//。 
//
// 
//
// 示例 1： 
//
// 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
//输出：9
// 
//
// 示例 2： 
//
// 输入：grid = [[1,1,0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length <= 100 
// 1 <= grid[0].length <= 100 
// grid[i][j] 为 0 或 1 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 181 👎 0

package leetcode.editor.cn;

//最大的以 1 为边界的正方形

/**
 * @author fabian
 * @date 2023-02-17 17:18:06
 */
public class P1139_Largest1BorderedSquare {

    public static void main(String[] args) {
        Solution solution = new P1139_Largest1BorderedSquare().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largest1BorderedSquare(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] left = new int[m + 1][n + 1];
            int[][] up = new int[m + 1][n + 1];
            int maxBorder = 0;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (grid[i - 1][j - 1] == 1) {
                        left[i][j] = left[i][j - 1] + 1;
                        up[i][j] = up[i - 1][j] + 1;
                        int border = Math.min(left[i][j], up[i][j]);
                        while (left[i - border + 1][j] < border || up[i][j - border + 1] < border) {
                            border--;
                        }
                        maxBorder = Math.max(maxBorder, border);
                    }
                }
            }
            return maxBorder * maxBorder;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}