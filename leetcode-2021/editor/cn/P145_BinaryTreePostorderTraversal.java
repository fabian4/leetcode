//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 650 👎 0


package leetcode.editor.cn;

//二叉树的后序遍历

import leetcode.editor.cn.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fabian
 * @date 2021-08-17 20:45:44
 */
public class P145_BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P145_BinaryTreePostorderTraversal().new Solution();

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
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            postorderTraversal(root, list);
            return list;
        }

        public void postorderTraversal(TreeNode root, List<Integer> list) {
            if (root != null) {
                postorderTraversal(root.left, list);
                postorderTraversal(root.right, list);
                list.add(root.val);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}