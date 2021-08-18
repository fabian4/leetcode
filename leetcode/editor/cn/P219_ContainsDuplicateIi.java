//给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值
// 至多为 k。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1], k = 3
//输出: true 
//
// 示例 2: 
//
// 输入: nums = [1,0,1,1], k = 1
//输出: true 
//
// 示例 3: 
//
// 输入: nums = [1,2,3,1,2,3], k = 2
//输出: false 
// Related Topics 数组 哈希表 滑动窗口 
// 👍 296 👎 0


package leetcode.editor.cn;

//存在重复元素 II

import java.util.HashSet;
import java.util.Set;

/**
 * @author fabian
 * @date 2021-08-18 21:58:57
 */
public class P219_ContainsDuplicateIi {
    public static void main(String[] args) {
        Solution solution = new P219_ContainsDuplicateIi().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < nums.length; ++i) {
				if (set.contains(nums[i])) {
					return true;
				}
				set.add(nums[i]);
				if (set.size() > k) {
					set.remove(nums[i - k]);
				}
			}
			return false;
        }
    }
	//leetcode submit region end(Prohibit modification and deletion)

}