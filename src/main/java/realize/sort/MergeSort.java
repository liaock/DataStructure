package realize.sort;

/**
 * Created by dell on 2021/9/12.
 */
public class MergeSort {
    void sort(int[] arr, int start, int end,int []temp) {
        if(start >= end){
            return;
        }
        int middle = (start + end)/2;
        sort(arr,start,middle,temp);
        sort(arr,middle+1,end,temp);
        merge(arr,start,middle,end,temp);//将两个有序子数组合并操作o
    }

    private void merge(int[] arr, int start, int middle, int end,int[]temp) {
        int index=0;
        int i=start;    //左序列指针
        int j=middle+1;  //右序列指针
        while (i<=middle && j<=end){
            if(arr[i] < arr[j]){
                temp[index++] = arr[i++];
            }else {
                temp[index++] = arr[j++];
            }
        }
        while (i<=middle){
            temp[index++] = arr[i++];
        }
        while (j<=end){
            temp[index++] = arr[j++];
        }
        index = 0;
        while(start <= end){
            arr[start++] = temp[index++];
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 7, 3, 9, 2, 5};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr, 0, arr.length - 1,new int[arr.length]);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}