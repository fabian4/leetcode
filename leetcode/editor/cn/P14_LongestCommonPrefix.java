//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1703 👎 0


package leetcode.editor.cn;

//最长公共前缀

/**
 * @author fabian
 * @date 2021-07-27 18:04:16
 */
public class P14_LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new P14_LongestCommonPrefix().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            StringBuilder ans = new StringBuilder();
            if (strs.length <= 0) {
                return ans.toString();
            }
            for (int i = 0; i < strs[0].length(); i++) {
                char temp = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (strs[j].length() <= i || temp != strs[j].charAt(i)) {
                        return ans.toString();
                    }
                }
                ans.append(temp);
            }
            return ans.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}