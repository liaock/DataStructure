package list.linkedList;

/**
 * 单链表
 * Created by liaock on 2021/8/28
 **/
public class LinkedList<E>  {

    class Node<E> {
        public E data;
        public Node<E> next;

    }

    class MyIterator implements Iterator<Node<E>>{

        int index;

        public Boolean hasNext() {
            if(index < size()){
                return true;
            }
            return false;
        }

        public Node<E> next() {
            if(this.hasNext()){
                Node<E> eNode = get(index);
                index ++ ;
                return eNode;
            }
            return null;
        }
    }


    public LinkedList(){
        // 使用哨兵处理  头尾节点为空的情况.
        Node guard = new Node();
        this.head = guard;
        this.tail = guard;
    }

    public Node head = null;
    public Node tail = null;
    private int size;

    public void add(E data){
        this.addAtTail(data);
    }

    public void add(E data,int index){
        Node<E> node = new Node<E>();
        node.data = data;
        if(index == 0){
            this.head = node;
        }else{
            Node<E> beforeNode = get(index-1);
            Node<E> afterNode = get(index);
            node.next = afterNode;
            beforeNode.next = node;
        }
        size ++ ;
    }

    public Node<E> get(int index){
        int i = 0;
        Node node = head;
        while (i <= index){
            if(i != 0 ){
                node = node.next;
            }
            i ++;
        }
        return node;
    }

    public int size(){
        return size;
    }


//    @Override
//    public String toString() {
//        String str = "LinkedList[";
//        Iterator<Node<E>>iterator = this.iterator();
//        while (iterator.hasNext()){
//            Node<E> next = iterator.next();
//            str += next.data + ",";
//        }
//        str += "]";
//        return str;
//    }

    /**
     * 在尾节点添加
     */
    private void addAtTail(E data){
        Node<E> node = new Node<E>();
        node.data = data;
        if(size == 0){
            this.head = node;
            this.tail = node;
        }else {
            this.tail.next = node;
            this.tail = node;
        }
        size ++ ;
    }

    /**
     * 重写 iterator
     * @return
     */
    public Iterator <Node<E>> iterator() {
        return new MyIterator();
    }
    

}
