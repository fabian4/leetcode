//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1705 👎 0


package leetcode.editor.cn;

//电话号码的字母组合

import java.util.ArrayList;
import java.util.List;

/**
 * @author fabian
 * @date 2022-02-11 20:31:25
 */
public class P17_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new P17_LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.println(solution.letterCombinations("23"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        String[] list = new String[]{
                "abc", "def", "ghi", "jkl", "mon", "pqrs", "tuv", "wxyz"
        };

        public List<String> letterCombinations(String digits) {
            List<String> ans = new ArrayList<>();
            if ("".equals(digits)) {
                return ans;
            }
            backTrace(ans, digits, 0, new StringBuffer());
            return ans;
        }

        public void backTrace(List<String> ans, String digits, int index, StringBuffer target) {
            if (index == digits.length()) {
                ans.add(target.toString());
                return;
            }
            String source = list[Integer.parseInt(digits.substring(index, index + 1)) - 2];
            for (int i = 0; i < source.length(); i++) {
                target.append(source.charAt(i));
                backTrace(ans, digits, index + 1, target);
                target.deleteCharAt(index);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}