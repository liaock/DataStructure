package practice.leetCode.top200;

import practice.leetCode.base.ListNode;

/**
 *
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * Created by dell on 2022/1/17.
 */
public class day11_链表_删除链表倒数第N个结点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode resutNode = dummy;
        int index1 = 0;
        int index2 = 0;
        while (head != null){
            ++ index1;
            head = head.next;
        }

        while (dummy != null ){
            if(index2 == index1 - n){
                dummy.next = dummy.next.next;
                return resutNode.next;
            }else {
                ++ index2;
                dummy = dummy.next;
            }
        }
        return dummy.next;

    }

    public static void main(String[] args) {
        day11_链表_删除链表倒数第N个结点 obj = new day11_链表_删除链表倒数第N个结点();
        //ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3)));
        ListNode listNode = obj.removeNthFromEnd(head, 2);
        System.out.println(listNode);
    }



}
