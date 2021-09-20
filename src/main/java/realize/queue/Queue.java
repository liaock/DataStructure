package realize.queue;
/**
 *
 * 循环队列.
 * 避免数据搬移.
 * Created by liaock on 2021/8/29
 **/

public class Queue<T extends Object> {

    /**
     * data数组
     */
    private T [] dataArr;

    /**
     * 队头指针
     */
    private int head;

    /**
     * 队尾指针
     */
    private int tail;

    private int capcity;


    public Queue(int capcity){
        this.capcity = capcity;
        dataArr = (T[])new Object[capcity];
    }

    public boolean push(T data){
        if(tail > capcity - 1 && head == 0){
            return false;
        }else{
            if(tail >= capcity -1 && head !=0){
                for (int i = head; i < dataArr.length; i++) {
                    dataArr[i-head] = dataArr[i];
                }
                tail = tail - head;
                head = 0;
            }
            dataArr[tail] = data;
            tail ++;
            return true;
        }

    }
    public T pop(){
        if(head == tail){
            return null;
        }
        T data = dataArr[head];
        dataArr[head] = null;
        head ++;
        return data;
    }
}
