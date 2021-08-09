//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的
//句子。 
//
// 说明： 
//
// 
// 分隔时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入:
//s = "catsanddog"
//wordDict = ["cat", "cats", "and", "sand", "dog"]
//输出:
//[
//  "cats and dog",
//  "cat sand dog"
//]
// 
//
// 示例 2： 
//
// 输入:
//s = "pineapplepenapple"
//wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
//输出:
//[
//  "pine apple pen apple",
//  "pineapple pen apple",
//  "pine applepen apple"
//]
//解释: 注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入:
//s = "catsandog"
//wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出:
//[]
// 
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 回溯 
// 👍 491 👎 0


package leetcode.editor.cn;

//单词拆分 II

import java.util.*;

/**
 * @author fabian
 * @date 2021-08-09 22:24:37
 */
public class P140_WordBreakIi{
	 public static void main(String[] args) {
	 	 Solution solution = new P140_WordBreakIi().new Solution();
	 
	 }
	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public List<String> wordBreak(String s, List<String> wordDict) {
			Map<Integer, List<List<String>>> map = new HashMap<>();
			List<List<String>> wordBreaks = backtrack(s, s.length(), new HashSet<>(wordDict), 0, map);
			List<String> breakList = new LinkedList<>();
			for (List<String> wordBreak : wordBreaks) {
				breakList.add(String.join(" ", wordBreak));
			}
			return breakList;
		}

		public List<List<String>> backtrack(String s, int length, Set<String> wordSet, int index, Map<Integer, List<List<String>>> map) {
			if (!map.containsKey(index)) {
				List<List<String>> wordBreaks = new LinkedList<>();
				if (index == length) {
					wordBreaks.add(new LinkedList<>());
				}
				for (int i = index + 1; i <= length; i++) {
					String word = s.substring(index, i);
					if (wordSet.contains(word)) {
						List<List<String>> nextWordBreaks = backtrack(s, length, wordSet, i, map);
						for (List<String> nextWordBreak : nextWordBreaks) {
							LinkedList<String> wordBreak = new LinkedList<>(nextWordBreak);
							wordBreak.offerFirst(word);
							wordBreaks.add(wordBreak);
						}
					}
				}
				map.put(index, wordBreaks);
			}
			return map.get(index);
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}