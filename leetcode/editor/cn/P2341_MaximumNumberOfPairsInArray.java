//给你一个下标从 0 开始的整数数组 nums 。在一步操作中，你可以执行以下步骤： 
//
// 
// 从 nums 选出 两个 相等的 整数 
// 从 nums 中移除这两个整数，形成一个 数对 
// 
//
// 请你在 nums 上多次执行此操作直到无法继续执行。 
//
// 返回一个下标从 0 开始、长度为 2 的整数数组 answer 作为答案，其中 answer[0] 是形成的数对数目，answer[1] 是对 nums 
//尽可能执行上述操作后剩下的整数数目。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,3,2,1,3,2,2]
//输出：[3,1]
//解释：
//nums[0] 和 nums[3] 形成一个数对，并从 nums 中移除，nums = [3,2,3,2,2] 。
//nums[0] 和 nums[2] 形成一个数对，并从 nums 中移除，nums = [2,2,2] 。
//nums[0] 和 nums[1] 形成一个数对，并从 nums 中移除，nums = [2] 。
//无法形成更多数对。总共形成 3 个数对，nums 中剩下 1 个数字。 
//
// 示例 2： 
//
// 输入：nums = [1,1]
//输出：[1,0]
//解释：nums[0] 和 nums[1] 形成一个数对，并从 nums 中移除，nums = [] 。
//无法形成更多数对。总共形成 1 个数对，nums 中剩下 0 个数字。 
//
// 示例 3： 
//
// 输入：nums = [0]
//输出：[0,1]
//解释：无法形成数对，nums 中剩下 1 个数字。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
//
// Related Topics 数组 哈希表 计数 👍 43 👎 0

package leetcode.editor.cn;

//数组能形成多少数对

import java.util.Arrays;

/**
 * @author fabian
 * @date 2023-02-16 16:53:31
 */
public class P2341_MaximumNumberOfPairsInArray {

    public static void main(String[] args) {
        Solution solution = new P2341_MaximumNumberOfPairsInArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] numberOfPairs(int[] nums) {
            Arrays.sort(nums);
            int[] flag = new int[nums.length];
            Arrays.fill(flag, 0);
            int pair = 0;
            for (int i = 1; i < nums.length; i++) {
                if (flag[i - 1] == 0 && nums[i - 1] == nums[i]) {
                    pair++;
                    flag[i - 1] = 1;
                    flag[i] = 1;
                }
            }
            return new int[]{pair, nums.length - pair * 2};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}