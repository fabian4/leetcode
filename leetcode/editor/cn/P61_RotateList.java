//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 10⁹ 
// 
// Related Topics 链表 双指针 👍 722 👎 0


package leetcode.editor.cn;

//旋转链表

import base.ListNode;

/**
 * @author fabian
 * @date 2022-02-09 17:15:20
 */
public class P61_RotateList {
    public static void main(String[] args) {
        Solution solution = new P61_RotateList().new Solution();
        solution.rotateRight(ListNode.getFromArrayString("[1,2]"), 1);
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
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null || k == 0) {
                return head;
            }
            ListNode tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }

            ListNode newTail = head;
            ListNode help = head;
            while (k >= 0) {
                if (help.next != null) {
                    help = help.next;
                } else {
                    help = head;
                }
                k--;
            }

            while (help != null) {
                if (newTail.next != null) {
                    newTail = newTail.next;
                } else {
                    newTail = head;
                }
                help = help.next;
            }

            if (newTail == tail) {
                return head;
            }

            ListNode newHead = newTail.next;
            newTail.next = null;
            tail.next = head;

            return newHead;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}