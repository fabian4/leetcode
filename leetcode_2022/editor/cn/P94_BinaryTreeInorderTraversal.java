//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1258 👎 0


package leetcode_2022.editor.cn;

//二叉树的中序遍历

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fabian
 * @date 2022-02-11 20:23:22
 */
public class P94_BinaryTreeInorderTraversal{
	 public static void main(String[] args) {
	 	 Solution solution = new P94_BinaryTreeInorderTraversal().new Solution();
	 
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

	List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
		if(root != null){
			inorderTraversal(root.left);
			list.add(root.val);
			inorderTraversal(root.right);
		}
		return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}