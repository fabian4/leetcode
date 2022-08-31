//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 数组 回溯 👍 1176 👎 0


package leetcode.editor.cn;

//全排列 II

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author fabian
 * @date 2022-08-31 17:06:20
 */
public class P47_PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new P47_PermutationsIi().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            if (nums.length == 0) {
                return ans;
            }
            boolean[] flag = new boolean[nums.length];
            Arrays.sort(nums);
            backTrace(nums, flag, ans, new ArrayList<>());
            return ans;
        }

        void backTrace(int[] nums, boolean[] flag, List<List<Integer>> ans, List<Integer> output) {
            if (output.size() == nums.length) {
                if (!ans.contains(output)) {
                    ans.add(new ArrayList<>(output));
                }
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (flag[i] || (i > 0 && nums[i] == nums[i - 1] && !flag[i - 1])) {
                    continue;
                }
                output.add(nums[i]);
                flag[i] = true;
                backTrace(nums, flag, ans, output);
                flag[i] = false;
                output.remove(output.size() - 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
