package practice.leetCode.top200;

import practice.leetCode.base.ListNode;

/**
 *  https://leetcode-cn.com/problems/middle-of-the-linked-list/
 *
 * 我们可以继续优化方法二，用两个指针 slow 与 fast 一起遍历链表。
 * slow 一次走一步，fast 一次走两步。那么当 fast 到达链表的末尾时，slow 必然位于中间。
 * Created by dell on 2022/2/21.
 */
public class day18_快慢指针_获取链表中间结点 {

    private ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head,fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
