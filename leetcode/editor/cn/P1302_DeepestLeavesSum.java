//给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
//输出：15
// 
//
// 示例 2： 
//
// 
//输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//输出：19
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 10⁴] 之间。 
// 1 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 105 👎 0


package leetcode.editor.cn;

//层数最深叶子节点的和

import base.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author fabian
 * @date 2022-08-17 10:10:04
 */
public class P1302_DeepestLeavesSum {
    public static void main(String[] args) {
        Solution solution = new P1302_DeepestLeavesSum().new Solution();

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
        public int deepestLeavesSum(TreeNode root) {
            List<TreeNode> a = new ArrayList<>();
            List<TreeNode> b = new ArrayList<>();
            a.add(root);
            while (true) {
                if (b.size() == 0) {
                    for (TreeNode temp : a) {
                        if (temp.left != null) {
                            b.add(temp.left);
                        }
                        if (temp.right != null) {
                            b.add(temp.right);
                        }
                    }
                    if(b.size() == 0){
                        int sum = 0;
                        for (TreeNode temp : a) {
                            sum += temp.val;
                        }
                        return sum;
                    }
                    a.clear();
                } else if (a.size() == 0) {
                    for (TreeNode temp : b) {
                        if (temp.left != null) {
                            a.add(temp.left);
                        }
                        if (temp.right != null) {
                            a.add(temp.right);
                        }
                    }
                    if(a.size() == 0){
                        int sum = 0;
                        for (TreeNode temp : b) {
                            sum += temp.val;
                        }
                        return sum;
                    }
                    b.clear();
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
