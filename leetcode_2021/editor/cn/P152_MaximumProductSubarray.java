//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 1227 👎 0


package leetcode.editor.cn;

//乘积最大子数组

/**
 * @author fabian
 * @date 2021-08-11 22:34:12
 */
public class P152_MaximumProductSubarray{
	 public static void main(String[] args) {
	 	 Solution solution = new P152_MaximumProductSubarray().new Solution();
	 
	 }
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
		public int maxProduct(int[] nums) {
			int maxF = nums[0], minF = nums[0], ans = nums[0];
			int length = nums.length;
			for (int i = 1; i < length; ++i) {
				int mx = maxF, mn = minF;
				maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
				minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
				ans = Math.max(maxF, ans);
			}
			return ans;
		}
}
//leetcode submit region end(Prohibit modification and deletion)

}