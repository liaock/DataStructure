package practice.leetCode.top200;

import practice.leetCode.base.ListNode;

/**
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * Created by dell on 2022/1/16.
 */
public class day10_链表_合并两个有序链表 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {


        ListNode newListNode = new ListNode(-1);
        ListNode indexNode = newListNode;

        while (list1 != null && list2 != null){
            if(list1.val <= list2.val){
                newListNode.next = new ListNode(list1.val);
                list1 = list1.next;
            }else {
                newListNode.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            newListNode = newListNode.next;

        }

        while(list1 != null){
            newListNode.next = new ListNode(list1.val);
            list1 = list1.next;
            newListNode = newListNode.next;
        }

        while(list2 != null){
            newListNode.next = new ListNode(list2.val);
            list2 = list2.next;
            newListNode = newListNode.next;
        }

        return indexNode.next;

    }


    public static void main(String[] args) {
        day10_链表_合并两个有序链表 obj = new day10_链表_合并两个有序链表();
//        ListNode list1 = new ListNode(1,new ListNode(2,new ListNode(4)));
//        ListNode list2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode list1 = new ListNode();
        ListNode list2 = new ListNode(0);
        ListNode listNode = obj.mergeTwoLists(null, null);

        System.out.println(listNode);

    }

}
