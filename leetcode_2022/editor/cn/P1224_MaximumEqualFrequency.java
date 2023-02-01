//给你一个正整数数组 nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回该前缀的长度： 
//
// 
// 从前缀中 恰好删除一个 元素后，剩下每个数字的出现次数都相同。 
// 
//
// 如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,2,1,1,5,3,3,5]
//输出：7
//解释：对于长度为 7 的子数组 [2,2,1,1,5,3,3]，如果我们从中删去 nums[4] = 5，就可以得到 [2,2,1,1,3,3]，里面每个数
//字都出现了两次。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1,2,2,2,3,3,3,4,4,4,5]
//输出：13
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 哈希表 👍 96 👎 0


package leetcode_2022.editor.cn;

//最大相等频率

import java.util.HashMap;
import java.util.Map;

/**
 * @author fabian
 * @date 2022-08-18 10:54:43
 */
public class P1224_MaximumEqualFrequency {
    public static void main(String[] args) {
        Solution solution = new P1224_MaximumEqualFrequency().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEqualFreq(int[] nums) {
            Map<Integer, Integer> freq = new HashMap<>();
            Map<Integer, Integer> count = new HashMap<>();
            int res = 0, maxFreq = 0;
            for (int i = 0; i < nums.length; i++) {
                if (count.getOrDefault(nums[i], 0) > 0) {
                    freq.put(count.get(nums[i]), freq.get(count.get(nums[i])) - 1);
                }
                count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
                maxFreq = Math.max(maxFreq, count.get(nums[i]));
                freq.put(count.get(nums[i]), freq.getOrDefault(count.get(nums[i]), 0) + 1);
                boolean ok = maxFreq == 1 ||
                        freq.get(maxFreq) * maxFreq + freq.get(maxFreq - 1) * (maxFreq - 1) == i + 1 && freq.get(maxFreq) == 1 ||
                        freq.get(maxFreq) * maxFreq + 1 == i + 1 && freq.get(1) == 1;
                if (ok) {
                    res = Math.max(res, i + 1);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
