package practice.sort;

/**
 * Created by dell on 2021/9/22.
 */
public class QuickSort {

    public void sort(int [] arr,int start,int end){
        if(start >= end) return;
        int partition = partition(arr, start, end);
        sort(arr,start,partition-1);
        sort(arr,partition+1,end);
    }

    private int partition(int[] arr, int start, int end) {
        int index = start;
        int temp = arr[end];
        for (int i = start; i <= end; i++) {
            if(arr[i] > temp){
                swap(arr,index,i);
                index ++;
            }
        }
        swap(arr,index,end);
        return index;
    }

    private void swap(int[] arr, int index, int i) {
        int temp;
        temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }

    public static void main(String[] args) {
        int[]arr = new int[]{2,1,7,3,9,2,5};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


}
