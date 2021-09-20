package realize.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 单链表反转
 * 链表中环的检测
 * 两个有序的链表合并
 * 删除链表中倒数第K个节点
 * 寻找链表的中间节点.
 *
 * Created by liaock on 2021/8/28
 **/

public class Main {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.add("hello");
        list.add("my");
        list.add("world");
        list.add("!");
        System.out.println("原始list:" + list);
        Iterator<LinkedList<String>.Node<String>> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().data);
        }
        LinkedList.Node node = reverseList(list.get(0),list);
        System.out.println("单链表反转:" + list);
        Iterator<LinkedList<String>.Node<String>> iterator2 = list.iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next().data);
        }
    }

    /**
     * 1.反转链表.
     * @param node
     */
    public static LinkedList.Node reverseList(LinkedList.Node node,LinkedList list){
        if(node == null || node.next == null){
            list.head = node;
            return node;
        }
        // 递归反转.
        LinkedList.Node next = node.next;
        LinkedList.Node newNode = reverseList(next,list);
        next.next = node;
        node.next = null;
        list.tail = node;
        return newNode;
    }

    /**
     * 链表中的环的检测方法1.用set记录 遍历的index
     */
    public boolean checkCircle1(LinkedList.Node node){
        // 用一个set存储遍历过的节点.
        Set<LinkedList.Node> set = new HashSet<LinkedList.Node>();
        while (node.next != null){
            if(set.add(node)){
                node = node.next;
            }else{
                return true;
            }
        }
        return false;
    }

    /**
     * 方法2：使用快慢指针.
     * 方法说明：快指针走的比较快，若链表有环，则一定会追上慢指针，若无环，则会走到链表末端。
     * @param node
     * @return
     */
    public boolean checkCircle2(LinkedList.Node node){
        LinkedList.Node fast = node;
        LinkedList.Node slow = node;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    /**
     * 两个有序链表合并
     * @param linkedList1
     * @param linkedList2
     */
    public void mergeList(LinkedList linkedList1,LinkedList linkedList2){

    }

    /**
     * 删除链表倒数第k个节点.
     * @param linkedList
     * @param k
     */
    public void delete(LinkedList linkedList,int k){

    }

    /**
     * 寻找链表的中间节点
     */
    public static LinkedList.Node searchMiddleNode(LinkedList linkedList){
        return null;
    }


}
