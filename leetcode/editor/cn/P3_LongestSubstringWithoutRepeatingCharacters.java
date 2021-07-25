//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 5800 👎 0


package leetcode.editor.cn;

//无重复字符的最长子串

import java.util.HashSet;

/**
 * @author fabian
 * @date 2021-07-25 18:19:48
 */
public class P3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new P3_LongestSubstringWithoutRepeatingCharacters().new Solution();
	}

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
			HashSet<Character> hashSet = new HashSet<>(s.length());
			int maxLength = 0;
			int r = -1;
			for (int i = 0; i < s.length(); i++) {
				while(r+1<s.length() && hashSet.add(s.charAt(r+1))){
					r++;
				}
				maxLength = Math.max(maxLength, hashSet.size());
				hashSet.remove(s.charAt(i));
			}
			return maxLength;
        }
    }
	//leetcode submit region end(Prohibit modification and deletion)

}