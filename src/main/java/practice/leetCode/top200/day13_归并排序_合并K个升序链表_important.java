package practice.leetCode.top200;

import practice.leetCode.base.ListNode;

import java.util.*;

/**
 *
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * Created by dell on 2022/1/19.
 */
public class day13_归并排序_合并K个升序链表_important {

    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> tempList = new ArrayList<>();
        if(lists == null || lists.length == 0){
            return null;
        }
        for (ListNode listNode : lists) {
            while (listNode != null){
                tempList.add(listNode);
                listNode = listNode.next;
            }
        }

        if(tempList.isEmpty()){
            return null;
        }

        Collections.sort(tempList, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode resultNode = new ListNode(-1);
        ListNode dumyNode =  resultNode;

        for (ListNode listNode : tempList) {
            resultNode.next = listNode;
            resultNode = resultNode.next;
        }
        return dumyNode.next;
    }

    public static void main(String[] args) {
        day13_归并排序_合并K个升序链表_important obj = new day13_归并排序_合并K个升序链表_important();
        ListNode listNode1 = new ListNode(1,new ListNode(4,new ListNode(5)));
        ListNode listNode2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode listNode3 = new ListNode(2,new ListNode(6));
        ListNode[] lists = new ListNode[]{listNode1,listNode2,listNode3};
        ListNode listNode = obj.mergeKLists(null);
        System.out.println(listNode);
    }
}
