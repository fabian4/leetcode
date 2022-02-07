package base;

import java.util.ArrayList;

/**
 * @author fabian
 * @date 2021-07-25 17:12
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode getFromArrayString(String list) {
        String[] split = list.replace("[", "").replace("]", "").split(",");
        if (split.length == 0) {
            return null;
        }
        ListNode head = new ListNode(Integer.parseInt(split[0]));
        ListNode tail = head;
        for (int i = 1; i < split.length; i++) {
            tail.next = new ListNode(Integer.parseInt(split[i]));
            tail = tail.next;
        }
        return head;
    }

    @Override
    public String toString() {
        ArrayList<Integer> list = new ArrayList<>();
        while (next!=null){
            list.add(val);
            next = next.next;
        }
        return list.toString();
    }

}

