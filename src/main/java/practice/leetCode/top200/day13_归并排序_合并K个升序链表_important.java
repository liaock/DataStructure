package practice.leetCode.top200;

import practice.leetCode.base.ListNode;

/**
 *
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * Created by dell on 2022/1/19.
 */
public class day13_归并排序_合并K个升序链表_important {

    public ListNode mergeKLists(ListNode[] lists) {
        return null;
    }

    public static void main(String[] args) {
        day13_归并排序_合并K个升序链表_important obj = new day13_归并排序_合并K个升序链表_important();
        ListNode listNode1 = new ListNode(1,new ListNode(4,new ListNode(5)));
        ListNode listNode2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode listNode3 = new ListNode(2,new ListNode(6));
        ListNode[] lists = new ListNode[]{listNode1,listNode2,listNode3};
        obj.mergeKLists(lists);
    }
}
