//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 字符串 二叉树 
// 👍 560 👎 0


package leetcode.editor.cn;

//二叉树的所有路径

import leetcode.editor.cn.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fabian
 * @date 2021-08-18 22:36:34
 */
public class P257_BinaryTreePaths{
	 public static void main(String[] args) {
	 	 Solution solution = new P257_BinaryTreePaths().new Solution();
	 
	 }
	//leetcode submit region begin(Prohibit modification and deletion)
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 */
	class Solution {
		public List<String> binaryTreePaths(TreeNode root) {
			List<String> paths = new ArrayList<>();
			constructPaths(root, "", paths);
			return paths;
		}

		public void constructPaths(TreeNode root, String path, List<String> paths) {
			if (root != null) {
				StringBuffer pathSB = new StringBuffer(path);
				pathSB.append(root.val);
				if (root.left == null && root.right == null) {  // 当前节点是叶子节点
					paths.add(pathSB.toString());  // 把路径加入到答案中
				} else {
					pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
					constructPaths(root.left, pathSB.toString(), paths);
					constructPaths(root.right, pathSB.toString(), paths);
				}
			}
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}