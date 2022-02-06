//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 732 👎 0


package leetcode.editor.cn;

//x 的平方根

/**
 * @author fabian
 * @date 2021-07-31 10:36:59
 */
public class P69_Sqrtx {
    public static void main(String[] args) {
        Solution solution = new P69_Sqrtx().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            int l = 0;
            int r = x;
            int mid = (l + r) / 2;
            while (l <= r) {
                if ((long)mid * mid == x) {
                    break;
                }
                if ((long)mid * mid > x) {
                    r = mid - 1;
                    mid = (l + r) / 2;
                }
                if ((long)mid * mid < x) {
                    l = mid + 1;
                    mid = (l + r) / 2;
                }
            }
            return mid;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}