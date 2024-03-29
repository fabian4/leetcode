//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 👍 1777 👎 0


package leetcode_2022.editor.cn;

//删除链表的倒数第 N 个结点

import base.ListNode;

/**
 * @author fabian
 * @date 2022-02-08 21:29:15
 */
public class P19_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new P19_RemoveNthNodeFromEndOfList().new Solution();
        solution.removeNthFromEnd(ListNode.getFromArrayString("[1,2,3,4,5]"), 2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode q = head;
            ListNode p = head;
            ListNode pre = null;
            for (int i = 0; i < n; i++) {
                q = q.next;
            }
            while (q != null) {
                pre = p;
                p = p.next;
                q = q.next;
            }
            if (pre == null) {
                return p.next;
            }
            pre.next = p.next;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}