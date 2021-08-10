//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// L0 → L1 → … → Ln-1 → Ln 
//请将其重新排列后变为： 
//
// L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [1,2,3,4]
//输出: [1,4,2,3] 
//
// 示例 2: 
//
// 
//
// 
//输入: head = [1,2,3,4,5]
//输出: [1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 104] 
// 1 <= node.val <= 1000 
// 
// Related Topics 栈 递归 链表 双指针 
// 👍 639 👎 0


package leetcode.editor.cn;

//重排链表

import leetcode.editor.cn.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fabian
 * @date 2021-08-10 21:15:27
 */
public class P143_ReorderList{
	 public static void main(String[] args) {
	 	 Solution solution = new P143_ReorderList().new Solution();
	 
	 }
	//leetcode submit region begin(Prohibit modification and deletion)
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	class Solution {
		public void reorderList(ListNode head) {
			List<ListNode> list = new ArrayList<>();
			ListNode p = head;
			while(p!=null){
				list.add(p);
				p = p.next;
			}
			int length = list.size();
			for(int i = 0; i<length/2; i++){
				p = list.get(i);
				ListNode q = p.next;
				p.next = list.get(length-i-1);
				p.next.next = q;
			}
			p.next.next = null;
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}