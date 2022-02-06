//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 1223 👎 0


package leetcode.editor.cn;

//数组中的第K个最大元素

import java.util.Random;

/**
 * @author fabian
 * @date 2021-08-14 22:56:30
 */
public class P215_KthLargestElementInAnArray{
	 public static void main(String[] args) {
	 	 Solution solution = new P215_KthLargestElementInAnArray().new Solution();
	 
	 }
	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		Random random = new Random();

		public int findKthLargest(int[] nums, int k) {
			return quickSelect(nums, 0, nums.length - 1, nums.length - k);
		}

		public int quickSelect(int[] a, int l, int r, int index) {
			int q = randomPartition(a, l, r);
			if (q == index) {
				return a[q];
			} else {
				return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
			}
		}

		public int randomPartition(int[] a, int l, int r) {
			int i = random.nextInt(r - l + 1) + l;
			swap(a, i, r);
			return partition(a, l, r);
		}

		public int partition(int[] a, int l, int r) {
			int x = a[r], i = l - 1;
			for (int j = l; j < r; ++j) {
				if (a[j] <= x) {
					swap(a, ++i, j);
				}
			}
			swap(a, i + 1, r);
			return i + 1;
		}

		public void swap(int[] a, int i, int j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}