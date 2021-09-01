//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 队列 哈希表 字符串 计数 👍 430 👎 0


package leetcode.editor.cn;

//字符串中的第一个唯一字符

/**
 * @author fabian
 * @date 2021-09-01 21:41:07
 */
public class P387_FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        Solution solution = new P387_FirstUniqueCharacterInAString().new Solution();
        System.out.println((char) ('a' + 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstUniqChar(String s) {
            int[] table = new int[26];
            for (int i = 0; i < s.length(); i++) {
                table[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < s.length(); i++) {
                if (table[s.charAt(i)-'a'] == 1) {
                    return i;
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}