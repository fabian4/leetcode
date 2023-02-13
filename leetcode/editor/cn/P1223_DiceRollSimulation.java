//有一个骰子模拟器会每次投掷的时候生成一个 1 到 6 的随机数。 
//
// 不过我们在使用它时有个约束，就是使得投掷骰子时，连续 掷出数字 i 的次数不能超过 rollMax[i]（i 从 1 开始编号）。 
//
// 现在，给你一个整数数组 rollMax 和一个整数 n，请你来计算掷 n 次骰子可得到的不同点数序列的数量。 
//
// 假如两个序列中至少存在一个元素不同，就认为这两个序列是不同的。由于答案可能很大，所以请返回 模 10^9 + 7 之后的结果。 
//
// 
//
// 示例 1： 
//
// 输入：n = 2, rollMax = [1,1,2,2,2,3]
//输出：34
//解释：我们掷 2 次骰子，如果没有约束的话，共有 6 * 6 = 36 种可能的组合。但是根据 rollMax 数组，数字 1 和 2 最多连续出现一次，所
//以不会出现序列 (1,1) 和 (2,2)。因此，最终答案是 36-2 = 34。
// 
//
// 示例 2： 
//
// 输入：n = 2, rollMax = [1,1,1,1,1,1]
//输出：30
// 
//
// 示例 3： 
//
// 输入：n = 3, rollMax = [1,1,1,2,2,3]
//输出：181
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 5000 
// rollMax.length == 6 
// 1 <= rollMax[i] <= 15 
// 
//
// Related Topics 数组 动态规划 👍 180 👎 0


package leetcode.editor.cn;

//掷骰子模拟

/**
 * @author fabian
 * @date 2023-02-10 18:32:20
 */
public class P1223_DiceRollSimulation {
    public static void main(String[] args) {
        Solution solution = new P1223_DiceRollSimulation().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static final int MOD = 1000000007;

        public int dieSimulator(int n, int[] rollMax) {
            int[][] d = new int[n + 1][6];
            int[] sum = new int[n + 1];
            sum[0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < 6; j++) {
                    int pos = Math.max(i - rollMax[j] - 1, 0);
                    int sub = ((sum[pos] - d[pos][j]) % MOD + MOD) % MOD;
                    d[i][j] = ((sum[i - 1] - sub) % MOD + MOD) % MOD;
                    if (i <= rollMax[j]) {
                        d[i][j] = (d[i][j] + 1) % MOD;
                    }
                    sum[i] = (sum[i] + d[i][j]) % MOD;
                }
            }
            return sum[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}