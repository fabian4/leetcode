//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -104 <= Node.val <= 104 
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 745 👎 0


package leetcode.editor.cn;

//平衡二叉树

import leetcode.editor.cn.base.TreeNode;

/**
 * @author fabian
 * @date 2021-08-16 22:07:27
 */
public class P110_BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P110_BalancedBinaryTree().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            } else {
                return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
            }
        }

        public int height(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                return Math.max(height(root.left), height(root.right)) + 1;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}