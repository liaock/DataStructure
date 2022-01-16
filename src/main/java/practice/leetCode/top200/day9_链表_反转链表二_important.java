package practice.leetCode.top200;

import practice.leetCode.base.ListNode;

/**
 *
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 *
 * Created by dell on 2022/1/15.
 */
public class day9_链表_反转链表二_important {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        // 设置虚拟头结点. 避免特殊处理
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;

        // 1.从虚拟结点往后走left - 1 个结点.来到left的前一个结点
        for (int i = 0; i < left-1; i++) {
            pre = pre.next;
        }


        // 2. 从pre结点再往后走right-left+1 个结点，来到right结点
        ListNode rigthNode = pre;
        for (int i = 0; i < right-left+1; i++) {
            rigthNode = rigthNode.next;
        }



        // 3.切断出一个子链表

        ListNode leftNode = pre.next;
        ListNode cur = rigthNode.next;
        pre.next = null;
        rigthNode.next = null;

        // 第 4 步：同第 206 题，反转链表的子区间
        reverseLinkedList(leftNode);

        //5.拼接链表
        pre.next = rigthNode;
        leftNode.next = cur;

        return dummyNode.next;





    }

    private void reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

    }


    public static void main(String[] args) {
        day9_链表_反转链表二_important obj = new day9_链表_反转链表二_important();
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode node = obj.reverseBetween(head,2,4);
        System.out.println(node);
    }

}
