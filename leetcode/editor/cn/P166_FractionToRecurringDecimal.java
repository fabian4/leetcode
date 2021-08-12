//给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。 
//
// 如果小数部分为循环小数，则将循环的部分括在括号内。 
//
// 如果存在多个答案，只需返回 任意一个 。 
//
// 对于所有给定的输入，保证 答案字符串的长度小于 104 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numerator = 1, denominator = 2
//输出："0.5"
// 
//
// 示例 2： 
//
// 
//输入：numerator = 2, denominator = 1
//输出："2"
// 
//
// 示例 3： 
//
// 
//输入：numerator = 2, denominator = 3
//输出："0.(6)"
// 
//
// 示例 4： 
//
// 
//输入：numerator = 4, denominator = 333
//输出："0.(012)"
// 
//
// 示例 5： 
//
// 
//输入：numerator = 1, denominator = 5
//输出："0.2"
// 
//
// 
//
// 提示： 
//
// 
// -231 <= numerator, denominator <= 231 - 1 
// denominator != 0 
// 
// Related Topics 哈希表 数学 字符串 
// 👍 244 👎 0


package leetcode.editor.cn;

//分数到小数

import java.util.HashMap;
import java.util.Map;

/**
 * @author fabian
 * @date 2021-08-12 21:53:00
 */
public class P166_FractionToRecurringDecimal {
    public static void main(String[] args) {
        Solution solution = new P166_FractionToRecurringDecimal().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            if (numerator == 0) {
                return "0";
            }
            StringBuilder fraction = new StringBuilder();
            // If either one is negative (not both)
            if (numerator < 0 ^ denominator < 0) {
                fraction.append("-");
            }
            // Convert to Long or else abs(-2147483648) overflows
            long dividend = Math.abs(Long.valueOf(numerator));
            long divisor = Math.abs(Long.valueOf(denominator));
            fraction.append(String.valueOf(dividend / divisor));
            long remainder = dividend % divisor;
            if (remainder == 0) {
                return fraction.toString();
            }
            fraction.append(".");
            Map<Long, Integer> map = new HashMap<>();
            while (remainder != 0) {
                if (map.containsKey(remainder)) {
                    fraction.insert(map.get(remainder), "(");
                    fraction.append(")");
                    break;
                }
                map.put(remainder, fraction.length());
                remainder *= 10;
                fraction.append(String.valueOf(remainder / divisor));
                remainder %= divisor;
            }
            return fraction.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}