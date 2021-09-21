package realize.tree.heap;

/**
 * Created by dell on 2021/9/21.
 * 堆是一个完全二叉树.
 *
 */
public class Heap {
    private int[] a;// 数组，从下标1开始存储数据
    private int n; //堆中可以存储的最大数据个数
    private int count; //堆中已经存出的个数

    public Heap(int capacity){
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }
    public void insert(int data){
        if(count > n){
            return;
        }
        ++ count;
        int i = count;
        while (i/2 >0 && a[i]>i/2){
            swap(a,i,i/2);
            i=i/2;
        }
    }

    public void removeMax(){
        if(count == 0) return; //堆中无元素
        a[1] = a[count];
        --count;
        heapify(a,count,1);
    }

    private void heapify(int[] a, int count, int i) {
        while (true){

        }

    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
