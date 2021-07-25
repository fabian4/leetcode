//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治 
// 👍 4285 👎 0


package leetcode.editor.cn;

//寻找两个正序数组的中位数

import java.util.Arrays;

/**
 * @author fabian
 * @date 2021-07-25 19:06:43
 */
public class P4_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new P4_MedianOfTwoSortedArrays().new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[0], new int[]{1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;
            if (n1>n2) {
                return findMedianSortedArrays(nums2, nums1);
            }
            int k = (n1 + n2 + 1)/2;
            int left = 0;
            int right = n1;
            while(left < right){
                int m1 = left +(right - left)/2;
                int m2 = k - m1;
                if (nums1[m1] < nums2[m2-1]) {
                    left = m1 + 1;
                } else {
                    right = m1;
                }
            }
            int m1 = left;
            int m2 = k - left;
            int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1-1],
                    m2 <= 0 ? Integer.MIN_VALUE : nums2[m2-1]);
            if ((n1 + n2) % 2 == 1) {
                return c1;
            }
            int c2 = Math.min( m1 >= n1 ? Integer.MAX_VALUE :nums1[m1],
                    m2 >= n2 ? Integer.MAX_VALUE : nums2[m2]);
            return (c1 + c2) * 0.5;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}