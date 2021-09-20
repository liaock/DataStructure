package realize.sort;

/**
 * Created by liaock on 2021/9/12.
 */
public class QuickSort {
    void sort(int []arr,int start,int end){
        if(start>=end){
            return ;
        }
        int partition = partition(arr,start,end);
        sort(arr,start,partition-1);
        sort(arr,partition+1,end);
    }
    private int partition(int[] arr, int start, int end) {
        int point = start;
        int initial = arr[start];
        for (int i = start; i <= end; i++) {
            if(arr[i]<initial){
                swap(arr,i,point);
                point ++;
            }
        }
        swap(arr,point,start);
        return point;
    }

    private void swap(int[]arr,int i,int j){
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
