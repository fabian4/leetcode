//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// Related Topics 数组 回溯 👍 1091 👎 0


package leetcode.editor.cn;

//组合总和 II

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author fabian
 * @date 2022-08-31 14:39:48
 */
public class P40_CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new P40_CombinationSumIi().new Solution();
        solution.combinationSum2(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 30);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            backTrace(candidates, 0, new ArrayList<>(), target);
            return ans;
        }

        void backTrace(int[] candidates, int index, List<Integer> list, int target) {
            if (target == 0) {
                List<Integer> solution = new ArrayList<>(list);
                Collections.sort(solution);
                if (!ans.contains(solution)) {
                    ans.add(solution);
                }
                return;
            }
            if (index >= candidates.length) {
                return;
            }
            if (candidates[index] > target) {
                backTrace(candidates, index + 1, list, target);
                return;
            }
            list.add(candidates[index]);
            backTrace(candidates, index + 1, list, target - candidates[index]);
            while (index + 1 < candidates.length && list.get(list.size() - 1) == candidates[index + 1]) {
                index++;
            }
            list.remove(list.size() - 1);
            backTrace(candidates, index + 1, list, target);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
