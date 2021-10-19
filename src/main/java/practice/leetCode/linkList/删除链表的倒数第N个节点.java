package practice.leetCode.linkList;

import realize.linkedList.LinkedList;

import java.util.HashMap;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 例：
 *      输入：head = [1,2,3,4,5], n = 2
 *      输出：[1,2,3,5]
 *
 * Created by liaock on 2021/10/19
 **/

public class 删除链表的倒数第N个节点 {

    public LinkedList.Node removeNthFromEnd(LinkedList.Node head, int n) {
        int i = 0;
        HashMap<Integer,LinkedList.Node> map = new HashMap<Integer, LinkedList.Node>();
        while (head != null){
            i++;
            map.put(i,head);
            head = head.next;
        }
        if(n == i && n == 1){
            return null;
        }
        if(i-n+1 == 1){
            return map.get(2);
        }
        map.get(i-n).next =  map.get(i-n).next.next;
        return map.get(1);
    }


    public static void main(String[] args) {
        删除链表的倒数第N个节点 test = new 删除链表的倒数第N个节点();
        LinkedList linkedList = new LinkedList();
        LinkedList.Node node =linkedList.new Node(1,linkedList.new Node(2,null));
        LinkedList.Node node1 = test.removeNthFromEnd(node, 2);
        System.out.println(node1);
    }

}
