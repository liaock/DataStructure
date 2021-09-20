package realize.sort;

/**
 * Created by liaock on 2021/8/30
 **/

public class Sort {

    /**
     * 冒泡排序.  原地排序，稳定排序
     */
    void bubbleSort(int []arr){
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length-i-1; j++) {
                int temp;
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            // 没有数据交换，提前退出.
            if(!flag){
                break;
            }
        }
    }

    /**
     * 插入排序. 原地排序，稳定排序
     * @param arr
     */
    void insertionSort(int []arr){
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i-1;
            for (; j >= 0; --j) {
                if(arr[j] > value){
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+1] = value;
        }
    }

    /**
     * 选择排序. 不稳定算法.
     * @param arr
     */
    void selectionSort(int []arr){
        for (int i = 0; i < arr.length-1; i++) {
            int max =  arr[i];
            for (int j = i; j < arr.length; j++) {
                if(arr[j]>max){
                    max = arr[j];
                    arr[j] = arr[i];
                    arr[i] = max;
                }
            }
        }
    }

    /**
     * 归并排序  稳定排序.
     * @param arr
     */
    void mergeSort(int []arr){

    }

    /**
     * 快速排序. 不稳定排序.
     * @param arr
     */
    void quickSort(int []arr,int p,int r){
        if(p>=r){
            return;
        }
        int part = partition(arr, p, r);
        quickSort(arr, p, part-1);
        quickSort(arr, part+1, r);
    }

    private int partition(int[] arr, int p, int r) {
        int data = arr[r];
        int head = p;
        for (int j = p; j <= r; j++) {
            if(arr[j]<data){
                int temp = arr[j];
                arr[j] = arr[head];
                arr[head] = temp;
                head ++;
            }
        }

        arr[r] = arr[head];
        arr[head] = data;
        return head;
    }

    private void swap(int[]arr,int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]= temp;
    }


    public static void main(String[] args) {
        int [] arr = {2,1,7,4,7,9,3,13,10,12};
        //int [] arr = {2,1,7};
        Sort sort = new Sort();
        //realize.sort.bubbleSort(arr);
        //realize.sort.insertionSort(arr);
        sort.quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


}
