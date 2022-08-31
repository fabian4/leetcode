//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2200 👎 0


package leetcode.editor.cn;

//全排列

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fabian
 * @date 2022-08-31 17:06:42
 */
public class P46_Permutations {
    public static void main(String[] args) {
        Solution solution = new P46_Permutations().new Solution();
        boolean[] flag = new boolean[8];
        System.out.println(Arrays.toString(flag));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            if (nums.length == 0) {
                return ans;
            }
            boolean[] flag = new boolean[nums.length];
            backTrace(nums, flag, ans, new ArrayList<>());
            return ans;
        }

        void backTrace(int[] nums, boolean[] flag, List<List<Integer>> ans, List<Integer> output) {
            if (output.size() == nums.length) {
                ans.add(new ArrayList<>(output));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!flag[i]) {
                    output.add(nums[i]);
                    flag[i] = true;
                    backTrace(nums, flag, ans, output);
                    flag[i] = false;
                    output.remove(output.size() - 1);
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
