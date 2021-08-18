//给定一个无重复元素的有序整数数组 nums 。 
//
// 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 num
//s 的数字 x 。 
//
// 列表中的每个区间范围 [a,b] 应该按如下格式输出： 
//
// 
// "a->b" ，如果 a != b 
// "a" ，如果 a == b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [0,1,2,4,5,7]
//输出：["0->2","4->5","7"]
//解释：区间范围是：
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,2,3,4,6,8,9]
//输出：["0","2->4","6","8->9"]
//解释：区间范围是：
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
// 
//
// 示例 3： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 4： 
//
// 
//输入：nums = [-1]
//输出：["-1"]
// 
//
// 示例 5： 
//
// 
//输入：nums = [0]
//输出：["0"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 20 
// -231 <= nums[i] <= 231 - 1 
// nums 中的所有值都 互不相同 
// nums 按升序排列 
// 
// Related Topics 数组 
// 👍 171 👎 0


package leetcode.editor.cn;

//汇总区间

import java.util.ArrayList;
import java.util.List;

/**
 * @author fabian
 * @date 2021-08-18 22:12:20
 */
public class P228_SummaryRanges {
    public static void main(String[] args) {
        Solution solution = new P228_SummaryRanges().new Solution();
        System.out.println(solution.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (i + 1 == nums.length || nums[i + 1] != nums[i] + 1) {
                    list.add(String.valueOf(nums[i]));
                } else {
                    int j = i + 2;
                    while (j < nums.length && nums[j] == nums[j - 1] + 1) {
                        j++;
                    }
                    list.add(nums[i] + "->" + nums[j - 1]);
                    i = j - 1;
                }
            }
            return list;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}