//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2375 👎 0


package leetcode_2022.editor.cn;

//括号生成

import java.util.ArrayList;
import java.util.List;

/**
 * @author fabian
 * @date 2022-02-21 21:51:29
 */
public class P22_GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22_GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            backTrace(n, n, 0, ans, new StringBuffer());
            return ans;
        }

        void backTrace(int n, int left, int index, List<String> list, StringBuffer sb) {
            if (index == n * 2) {
                list.add(sb.toString());
                return;
            }
            if (left > 0) {
                sb.append("(");
                backTrace(n, left - 1, index + 1, list, sb);
                sb.deleteCharAt(index);
            }
            if (left != n) {
                sb.append(")");
                backTrace(n, left, index + 1, list, sb);
                sb.deleteCharAt(index);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}