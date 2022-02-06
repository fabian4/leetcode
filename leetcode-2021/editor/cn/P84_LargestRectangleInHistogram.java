//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=105 
// 0 <= heights[i] <= 104 
// 
// Related Topics 栈 数组 单调栈 
// 👍 1461 👎 0


package leetcode.editor.cn;

//柱状图中最大的矩形

import java.util.Arrays;
import java.util.Stack;

/**
 * @author fabian
 * @date 2021-07-31 18:07:24
 */
public class P84_LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new P84_LargestRectangleInHistogram().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int[] left = new int[n];
            int[] right = new int[n];
            Arrays.fill(right, n);

            Stack<Integer> mono_stack = new Stack<>();
            for (int i = 0; i < n; ++i) {
                while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                    right[mono_stack.peek()] = i;
                    mono_stack.pop();
                }
                left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
                mono_stack.push(i);
            }

            int ans = 0;
            for (int i = 0; i < n; ++i) {
                ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
            }
            return ans;
//            int max = 0;
//            for (int i = 0; i < heights.length; i++) {
//                int left = i, right = i;
//                while (left - 1 >= 0 && heights[left - 1] >= heights[i]) {
//                    left--;
//                }
//                while (right + 1 < heights.length && heights[right + 1] >= heights[i]) {
//                    right++;
//                }
//                max = Math.max(max, heights[i] * (right - left + 1));
//            }
//            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}