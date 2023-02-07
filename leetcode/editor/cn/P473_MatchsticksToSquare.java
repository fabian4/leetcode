//你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。你 不能
//折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。 
//
// 如果你能使这个正方形，则返回 true ，否则返回 false 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: matchsticks = [1,1,2,2,2]
//输出: true
//解释: 能拼成一个边长为2的正方形，每边两根火柴。
// 
//
// 示例 2: 
//
// 
//输入: matchsticks = [3,3,3,3,4]
//输出: false
//解释: 不能用所有火柴拼成一个正方形。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= matchsticks.length <= 15 
// 1 <= matchsticks[i] <= 10⁸ 
// 
//
// Related Topics 位运算 数组 动态规划 回溯 状态压缩 👍 462 👎 0


package leetcode.editor.cn;

//火柴拼正方形

import java.util.Arrays;

/**
 * @author fabian
 * @date 2023-02-07 15:13:13
 */
public class P473_MatchsticksToSquare {
    public static void main(String[] args) {
        Solution solution = new P473_MatchsticksToSquare().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean makesquare(int[] matchsticks) {
            int totalLen = Arrays.stream(matchsticks).sum();
            if (totalLen % 4 != 0) {
                return false;
            }
            int len = totalLen / 4, n = matchsticks.length;
            int[] dp = new int[1 << n];
            Arrays.fill(dp, -1);
            dp[0] = 0;
            for (int s = 1; s < (1 << n); s++) {
                for (int k = 0; k < n; k++) {
                    if ((s & (1 << k)) == 0) {
                        continue;
                    }
                    int s1 = s & ~(1 << k);
                    if (dp[s1] >= 0 && dp[s1] + matchsticks[k] <= len) {
                        dp[s] = (dp[s1] + matchsticks[k]) % len;
                        break;
                    }
                }
            }
            return dp[(1 << n) - 1] == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}