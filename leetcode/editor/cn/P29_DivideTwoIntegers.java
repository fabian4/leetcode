//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。 
//
// 返回被除数 dividend 除以除数 divisor 得到的商。 
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2 
//
// 
//
// 示例 1: 
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3 
//
// 示例 2: 
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2 
//
// 
//
// 提示： 
//
// 
// 被除数和除数均为 32 位有符号整数。 
// 除数不为 0。 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。 
// 
// Related Topics 位运算 数学 
// 👍 624 👎 0


package leetcode.editor.cn;

//两数相除

/**
 * @author fabian
 * @date 2021-07-28 18:33:16
 */
public class P29_DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new P29_DivideTwoIntegers().new Solution();
        System.out.println(Math.abs(-2147483648));
        solution.divide(-2147483648, -1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int dividend, int divisor) {
            if (dividend == 0) {
                return 0;
            }
            if (dividend == divisor) {
                return 1;
            }
            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }
            boolean diffSign = false;
            if ((dividend < 0) != (divisor < 0)) {
                diffSign = true;
            }
            int i = 0;
            int j = 0;
            int sum = 0;
            int minus = 0;
            for (; ; ) {
                int temp = 0;
                minus = divisor << j;
                if (diffSign) {
                    temp = sum - minus;
                } else {
                    temp = sum + minus;
                }
                //需要考虑temp溢出的情况，因此判断条件加一个temp是否变号
                if ((dividend > 0 && (temp > dividend || temp < sum)) || (dividend < 0 && (temp < dividend || temp > sum))) {
                    if (j == 0) {
                        break; //即使只加一个除数也会超过被除数，因此退出循环。
                    }
                    j--; //试探增加量减半的情况
                    continue;
                }
                sum = temp;
                i += (1 << j); //累加被除数的个数
                j++;
            }

            if (diffSign) {
                return -i;
            }
            return i;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}