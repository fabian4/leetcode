//给定一个二叉树的
// root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。 
//
// 两个节点之间的路径长度 由它们之间的边数表示。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：root = [5,4,5,1,1,5]
//输出：2
// 
//
// 示例 2: 
//
// 
//
// 
//输入：root = [1,4,5,4,4,5]
//输出：2
// 
//
// 
//
// 提示: 
//
// 
// 树的节点数的范围是
// [0, 10⁴] 
// -1000 <= Node.val <= 1000 
// 树的深度将不超过 1000 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 633 👎 0


package leetcode_2022.editor.cn;

//最长同值路径

import base.TreeNode;

/**
 * @author fabian
 * @date 2022-09-02 10:17:29
 */
public class P687_LongestUnivaluePath {
    public static void main(String[] args) {
        Solution solution = new P687_LongestUnivaluePath().new Solution();

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
        int res;

        public int longestUnivaluePath(TreeNode root) {
            res = 0;
            dfs(root);
            return res;
        }

        public int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = dfs(root.left), right = dfs(root.right);
            int left1 = 0, right1 = 0;
            if (root.left != null && root.left.val == root.val) {
                left1 = left + 1;
            }
            if (root.right != null && root.right.val == root.val) {
                right1 = right + 1;
            }
            res = Math.max(res, left1 + right1);
            return Math.max(left1, right1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
