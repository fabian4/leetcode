//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 
// 👍 901 👎 0


package leetcode.editor.cn;

//分割等和子集

import java.util.Arrays;

/**
 * @author fabian
 * @date 2021-08-19 22:52:46
 */
public class P416_PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new P416_PartitionEqualSubsetSum().new Solution();
        solution.canPartition(new int[]{1, 5, 11, 5});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;

            // dp[i]中的i表示背包内总和
            // 题目中说：每个数组中的元素不会超过 100，数组的大小不会超过 200
            // 总和不会大于20000，背包最大只需要其中一半，所以10001大小就可以了
            int[] dp = new int[20000];
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 == 1) {
                return false;
            }
            int target = sum / 2;

            // 开始 01背包
            for (int num : nums) {
                for (int j = target; j >= num; j--) { // 每一个元素一定是不可重复放入，所以从大到小遍历
                    dp[j] = Math.max(dp[j], dp[j - num] + num);
                }
            }
            // 集合中的元素正好可以凑成总和target
            return dp[target] == target;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}