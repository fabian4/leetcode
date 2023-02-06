//给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//解释：[4,9] 也是可通过的
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 711 👎 0


package leetcode.editor.cn;

//两个数组的交集

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author fabian
 * @date 2023-02-06 14:56:13
 */
public class P349_IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new P349_IntersectionOfTwoArrays().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int length1 = nums1.length, length2 = nums2.length;
            int[] intersection = new int[length1 + length2];
            int index = 0, index1 = 0, index2 = 0;
            while (index1 < length1 && index2 < length2) {
                int num1 = nums1[index1], num2 = nums2[index2];
                if (num1 == num2) {
                    // 保证加入元素的唯一性
                    if (index == 0 || num1 != intersection[index - 1]) {
                        intersection[index++] = num1;
                    }
                    index1++;
                    index2++;
                } else if (num1 < num2) {
                    index1++;
                } else {
                    index2++;
                }
            }
            return Arrays.copyOfRange(intersection, 0, index);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}