package practice.leetCode.top200;

import practice.leetCode.base.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * Created by dell on 2022/2/22.
 */
public class day19_链表_环形链表2_important {
    public ListNode detectCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<ListNode>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }

    public static void main(String[] args) {
        day19_链表_环形链表2_important obj = new day19_链表_环形链表2_important();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(-4);
        a.next = b;
        b.next = a;
//        c.next = d;
//        d.next = b;
        ListNode listNode = obj.detectCycle(a);
        System.out.println(listNode);
    }
}
