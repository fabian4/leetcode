//给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。 
//
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// 
//// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：2, nums = [1,2]
//解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,1,1,1,2,2,3,3,4]
//输出：5, nums = [0,1,2,3,4]
//解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3 * 104 
// -104 <= nums[i] <= 104 
// nums 已按升序排列 
// 
//
// 
// Related Topics 数组 双指针 
// 👍 2133 👎 0


package leetcode.editor.cn;

//删除有序数组中的重复项

/**
 * @author fabian
 * @date 2021-07-28 17:31:07
 */
public class P26_RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Solution solution = new P26_RemoveDuplicatesFromSortedArray().new Solution();
        solution.removeDuplicates(new int[]{-50, -49, -48, -46, -46, -44, -44, -44, -44, -43, -43, -43, -42, -42, -41, -40, -39, -39, -38, -38, -37, -35, -34, -33, -31, -31, -30, -30, -28, -28, -27, -25, -22, -22, -22, -22, -22, -21, -21, -21, -21, -19, -18, -17, -17, -16, -16, -15, -15, -14, -13, -13, -10, -10, -9, -9, -8, -7, -7, -7, -7, -6, -5, -4, -4, -4, -4, -3, -3, -2, -2, -2, 0, 0, 1, 2, 2, 2, 3, 3, 4, 5, 5, 5, 7, 8, 8, 8, 10, 10, 14, 15, 16, 16, 18, 18, 19, 21, 23, 23, 24, 24, 24, 25, 25, 25, 26, 27, 28, 28, 30, 32, 32, 32, 34, 36, 37, 37, 37, 38, 38, 38, 39, 40, 40, 40, 41, 41, 43, 43, 43, 44, 45, 46, 46, 47, 48, 48, 50, 50, 50});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length < 2) {
                return nums.length;
            }
            int k;
            int j = 2;
            for (k = 1; k < nums.length; k++) {
                if (nums[k - 1] >= nums[k]) {
                    if (j < k) {
                        j = k;
                    }
                    while (j < nums.length && nums[k - 1] == nums[j]) {
                        j++;
                    }
                    if (j == nums.length) {
                        break;
                    }
                    nums[k] = nums[j];
                }
            }
            return k;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}