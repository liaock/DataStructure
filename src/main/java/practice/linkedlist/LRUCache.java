package practice.linkedlist;


import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by dell on 2021/9/20.
 */
public class LRUCache {

    private int capacity;

    private LinkedList<Data> linkedList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.linkedList = new LinkedList();
    }

    public int get(final int key) {
        Iterator<Data> iterator = linkedList.iterator();
        int k=-1;
        int index=0;
        while (iterator.hasNext()){
            if(iterator.next().key == key){
                k=index;
                break;
            }
            index++;
        }
        if(k != -1) {
            Data data1 = linkedList.get(k);
            //将K往后的前移一位，将key插入最后
            for (int i = k; i < linkedList.size() - 1; i++) {
                linkedList.set(i, linkedList.get(i + 1));
            }
            linkedList.set(linkedList.size() - 1, data1);
            return data1.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Data data = new Data(key,value);
        Iterator<Data> iterator = linkedList.iterator();

        int k=-1;
        int index = 0;
        // 找到上一次出现的下标.
        while (iterator.hasNext()){
            if(iterator.next().key == key){
                k=index;
                break;
            }
            index++;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            Data data1 = linkedList.get(i);
            if(data1.key == key){
                k=i;

                break;
            }
        }
        // 没出现过.
        if(k == -1) {
            if (linkedList.size() < capacity) {
                linkedList.add(data);
            } else {
                linkedList.set(0, null);
                for (int i = 0; i < linkedList.size() - 1; i++) {
                    linkedList.set(i, linkedList.get(i + 1));
                }
                linkedList.set(linkedList.size() - 1, data);
            }
        }else {
            //将K往后的前移一位，将key插入最后
            for (int i=k; i < linkedList.size()-1 ; i++) {
                linkedList.set(i,linkedList.get(i+1));
            }
            linkedList.set(linkedList.size()-1,data);
        }
    }

    class Data{
        private int key;
        private int value;

        public Data(int key, int value) {
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
