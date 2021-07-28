//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
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
// Related Topics 链表 双指针 
// 👍 1473 👎 0


package leetcode.editor.cn;

//删除链表的倒数第 N 个结点

import leetcode.editor.cn.base.ListNode;

import java.util.List;

/**
 * @author fabian
 * @date 2021-07-28 15:23:56
 */
public class P19_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new P19_RemoveNthNodeFromEndOfList().new Solution();

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
            ListNode p = head;
            ListNode q = head;
            int step = 0;
            while (q.next != null) {
                step++;
                q = q.next;
                if (step > n) {
                    p = p.next;
                }
            }
            if (step == 0) {
                return null;
            } else if (step == n - 1) {
                head = head.next;
                return head;
            }
            p.next = p.next.next;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}