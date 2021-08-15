//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
// 
// 
// Related Topics 栈 数学 字符串 
// 👍 440 👎 0


package leetcode.editor.cn;

//基本计算器 II

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author fabian
 * @date 2021-08-15 15:14:33
 */
public class P227_BasicCalculatorIi {
    public static void main(String[] args) {
        Solution solution = new P227_BasicCalculatorIi().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
			Deque<Integer> stack = new LinkedList<>();
			char preSign = '+';
			int num = 0;
			int n = s.length();
			for (int i = 0; i < n; ++i) {
				if (Character.isDigit(s.charAt(i))) {
					num = num * 10 + s.charAt(i) - '0';
				}
				if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
					switch (preSign) {
						case '+':
							stack.push(num);
							break;
						case '-':
							stack.push(-num);
							break;
						case '*':
							stack.push(stack.pop() * num);
							break;
						default:
							stack.push(stack.pop() / num);
					}
					preSign = s.charAt(i);
					num = 0;
				}
			}
			int ans = 0;
			while (!stack.isEmpty()) {
				ans += stack.pop();
			}
			return ans;
		}
    }
    //leetcode submit region end(Prohibit modification and deletion)

}