//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 
// 👍 1081 👎 0


package leetcode.editor.cn;

//回文链表

import leetcode.editor.cn.base.ListNode;

/**
 * @author fabian
 * @date 2021-08-15 15:23:23
 */
public class P234_PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new P234_PalindromeLinkedList().new Solution();

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
        public boolean isPalindrome(ListNode head) {
            ListNode pre = null;
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                ListNode temp = slow.next;
                if (pre != null) {
                    slow.next = pre;
                }
                pre = slow;
                fast = fast.next.next;
                slow = temp;
            }
            if (fast != null) {
                slow = slow.next;
            }
            while (slow != null) {
                if (slow.val != pre.val) {
                    return false;
                }
                slow = slow.next;
                pre = pre.next;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}