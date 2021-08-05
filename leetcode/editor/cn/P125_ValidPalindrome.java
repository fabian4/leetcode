//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 
//
// 示例 1: 
//
// 
//输入: "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串
// 
//
// 示例 2: 
//
// 
//输入: "race a car"
//输出: false
//解释："raceacar" 不是回文串
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 105 
// 字符串 s 由 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 
// 👍 401 👎 0


package leetcode.editor.cn;

//验证回文串

/**
 * @author fabian
 * @date 2021-08-05 23:33:10
 */
public class P125_ValidPalindrome{
	 public static void main(String[] args) {
	 	 Solution solution = new P125_ValidPalindrome().new Solution();
	 
	 }
	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public boolean isPalindrome(String s) {
			StringBuffer sgood = new StringBuffer();
			int length = s.length();
			for (int i = 0; i < length; i++) {
				char ch = s.charAt(i);
				if (Character.isLetterOrDigit(ch)) {
					sgood.append(Character.toLowerCase(ch));
				}
			}
			StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
			return sgood.toString().equals(sgood_rev.toString());
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}