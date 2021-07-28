//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1821 👎 0


package leetcode.editor.cn;

//合并两个有序链表

import leetcode.editor.cn.base.ListNode;

/**
 * @author fabian
 * @date 2021-07-28 16:30:53
 */
public class P21_MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new P21_MergeTwoSortedLists().new Solution();
        solution.mergeTwoLists(
                new ListNode(1, new ListNode(2, new ListNode(4))),
                new ListNode(1, new ListNode(3, new ListNode(4)))
        );
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = null, tail = null;
            while (l1 != null || l2 != null) {
                ListNode node = null;
				if(l1 == null || l2!=null&&l1.val >= l2.val){
				    node = new ListNode(l2.val);
				    l2 = l2.next;
                }else if(l2 == null || l1!=null&&l1.val < l2.val){
				    node = new ListNode(l1.val);
				    l1 = l1.next;
                }
				if(head==null){
				    head = tail = node;
                }else {
				    tail.next = node;
				    tail = tail.next;
                }
            }
            return head;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}