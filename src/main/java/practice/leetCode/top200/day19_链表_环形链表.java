package practice.leetCode.top200;

import practice.leetCode.base.ListNode;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * Created by dell on 2022/2/22.
 */
public class day19_链表_环形链表 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (fastNode != null && fastNode.next != null){
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if(slowNode == fastNode){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        day19_链表_环形链表 obj = new day19_链表_环形链表();
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(-4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;
        boolean flag = obj.hasCycle(a);
        System.out.println(flag);
    }
}
