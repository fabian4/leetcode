//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例：
//二叉树：[3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层序遍历结果：
//
//
//[
//  [3],
//  [9,20],
//  [15,7]
//]
//
// Related Topics 树 广度优先搜索 二叉树
// 👍 952 👎 0


package leetcode.editor.cn;

//二叉树的层序遍历

import leetcode.editor.cn.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author fabian
 * @date 2021-08-02 11:26:20
 */
public class P102_BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new P102_BinaryTreeLevelOrderTraversal().new Solution();

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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode p = queue.poll();
                    level.add(p.val);
                    if(p.left!=null){
                        queue.offer(p.left);
                    }
                    if(p.right!=null){
                        queue.offer(p.right);
                    }
                }
                list.add(level);
            }
            return list;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}