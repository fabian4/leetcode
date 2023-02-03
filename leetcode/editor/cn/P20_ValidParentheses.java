//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 3711 👎 0


package leetcode.editor.cn;

//有效的括号

import java.util.Stack;

/**
 * @author fabian
 * @date 2023-02-03 15:53:06
 */
public class P20_ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P20_ValidParentheses().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<Character>();
            for (int i = 0; i < s.length(); i++) {
                switch (s.charAt(i)) {
                    case '(' -> stack.push('(');
                    case ')' -> {
                        if (stack.isEmpty() || stack.pop() != '(') {
                            return false;
                        }
                    }
                    case '[' -> stack.push('[');
                    case ']' -> {
                        if (stack.isEmpty() || stack.pop() != '[') {
                            return false;
                        }
                    }
                    case '{' -> stack.push('{');
                    case '}' -> {
                        if (stack.isEmpty() || stack.pop() != '{') {
                            return false;
                        }
                    }
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}