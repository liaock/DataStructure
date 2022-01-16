package practice.leetCode.top200;

import practice.leetCode.base.ListNode;

/**
 * Created by dell on 2022/1/14.
 */
public class day9_反转链表_important {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode tempNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tempNode;
        }
        return pre;
    }


    public static void main(String[] args) {
        day9_反转链表_important obj = new day9_反转链表_important();
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        ListNode node = obj.reverseList(head);
        System.out.println(node);
    }

}
