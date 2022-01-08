package practice.leetCode.top200;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 输入：l1 = [2,4,3], l2 = [5,6,4]
 输出：[7,0,8]
 解释：342 + 465 = 807.
 * Created by liaock on 2022/1/7
 **/


// 注意用游标指向原始链表.
public class day1_链表_两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode listNode = root;
        while (true){
            listNode.val += l1.val + l2.val;
            if(listNode.val >= 10){
                listNode.next = new ListNode(1);
                listNode.val = listNode.val - 10;
                if(l1.next == null && l2.next == null) break;
            }else {
                if(l1.next == null && l2.next == null) break;
                listNode.next = new ListNode(0);
            }
            if(l1.next != null){
                l1 = l1.next;
                if(l2.next != null){
                    l2 = l2.next;
                }else{
                    l2.val = 0;
                }
            }else {
                l1.val = 0;
                if(l2.next != null){
                    l2 = l2.next;
                }
            }
            listNode = listNode.next;
        }
        return root;
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public static void main(String []args){
      day1_链表_两数相加 obj = new day1_链表_两数相加();
      ListNode node1 = obj.new ListNode(2);
      node1.next = obj.new ListNode(4);
      node1.next.next = obj.new ListNode(3);
      ListNode node2 = obj.new ListNode(5);
      node2.next = obj.new ListNode(6);
      node2.next.next = obj.new ListNode(4);
      ListNode listNode = obj.addTwoNumbers(node1, node2);
      System.out.println(listNode);
  }

}
