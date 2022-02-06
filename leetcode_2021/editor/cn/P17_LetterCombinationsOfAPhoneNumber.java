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
// Related Topics 哈希表 字符串 回溯 
// 👍 1414 👎 0


package leetcode.editor.cn;

//电话号码的字母组合

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author fabian
 * @date 2021-07-28 13:56:28
 */
public class P17_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new P17_LetterCombinationsOfAPhoneNumber().new Solution();
        solution.letterCombinations("23");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        List<String> list = new LinkedList<>();

        public List<String> letterCombinations(String digits) {
            if ("".equals(digits)) {
                return list;
            }
            int length = list.size();
            if (length == 0) {
                for (int i = 0; i < phoneMap.get(digits.charAt(0)).length(); i++) {
                    list.add(phoneMap.get(digits.charAt(0)).charAt(i) + "");
                }
                return letterCombinations(digits.substring(1));
            }
            for (int i = 0; i < length; i++) {
                String s = list.remove(0);
                String target = phoneMap.get(digits.charAt(0));
                for (int j = 0; j < target.length(); j++) {
                    list.add(s + target.charAt(j));
                }
            }
            return letterCombinations(digits.substring(1));
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}