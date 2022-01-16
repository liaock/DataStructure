package practice.leetCode.top200;

import practice.linkedHashMap.LRUCache;

import java.util.*;

/**
 * Created by dell on 2022/1/13.
 */
public class day8_LRU_important {
    private int capacity;
    private int size;
    HashMap<Integer,LinkedNode> cachedMap = new HashMap<>();
    LinkedNode head;
    LinkedNode tail;
    

    public day8_LRU_important(int capacity) {
        this.capacity = capacity;
        head = new LinkedNode(-1,-1);  // 邵兵
        tail = new LinkedNode(-1,-1); // 邵兵
        head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;
    }

    public int get(int key) {
        LinkedNode linkedNode = cachedMap.get(key);
        if(null == linkedNode){
            return -1;
        }else {
            removeNode(linkedNode);
            addAtHead(linkedNode);
            return linkedNode.value;
        }
    }

    public void put(int key, int value) {
        LinkedNode linkedNode = cachedMap.get(key);
        if(null == linkedNode){
            linkedNode = new LinkedNode(key,value);
            if(size == capacity){
                removeNode(tail.prev);
            }
            addAtHead(linkedNode);
        }else {
            linkedNode.value = value;
            removeNode(linkedNode);
            addAtHead(linkedNode);
        }
        size ++;
    }

    private void addAtHead(LinkedNode linkedNode) {
        cachedMap.put(linkedNode.key,linkedNode);
        linkedNode.next = head.next;
        head.next.prev = linkedNode;
        linkedNode.prev = head;
        head.next = linkedNode;
        size ++;
    }

    private void removeNode(LinkedNode linkedNode) {
        cachedMap.remove(linkedNode.key);
        linkedNode.next.prev = linkedNode.prev;
        linkedNode.prev.next = linkedNode.next;
        size --;
    }


    class LinkedNode{
        LinkedNode next;
        LinkedNode prev;
        private int key;
        private int value;
        public LinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
