package practice.linkedHashMap;

import java.util.HashMap;

/**
 * Created by dell on 2021/9/20.
 */
public class LRUCache {

    private int capacity;
    private int size;
    private HashMap<Integer,LinkedNode> cachedMap = new HashMap<Integer, LinkedNode>();
    LinkedNode head;
    LinkedNode tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new LinkedNode(-1,-1);  // 邵兵
        tail = new LinkedNode(-1,-1); // 邵兵
        head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;
    }

    public int get(final int key) {
        LinkedNode linkedNode = cachedMap.get(key);
        if(null == linkedNode){
            return -1;
        }
        removeNode(linkedNode);
        addAtHead(linkedNode);
        return linkedNode.value;
    }

    public void put(int key, int value) {
        LinkedNode linkedNode = cachedMap.get(key);
        if(linkedNode == null){
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
    }

    private void removeNode(LinkedNode node) {
        cachedMap.remove(node.key);
        node.next.prev = node.prev;
        node.prev.next = node.next;
        size --;
    }

    private void addAtHead(LinkedNode linkedNode) {
        cachedMap.put(linkedNode.key,linkedNode);
        linkedNode.next = head.next;
        head.next.prev = linkedNode;
        linkedNode.prev = head;
        head.next = linkedNode;
        size ++;
    }

    class LinkedNode{

        private int key;
        private int value;
        LinkedNode prev;
        LinkedNode next;

        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(2));
        lruCache.put(1,1);
        lruCache.put(4,1);
        System.out.println(lruCache.get(2));
    }

}
