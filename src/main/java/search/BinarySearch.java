package search;
/**
 * Created by liaock on 2021/9/2
 **/
public class BinarySearch {

     int binarySearch(int []arr,int target){
        int start = 0;
        int end = arr.length - 1;
        while (end >= start){
            int middle = (start + end)/2;
            if(arr[middle] == target) return middle;
            if(arr[middle]>target){
                end = middle - 1;
            }else{
                start = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
         int[] arr = new int[]{1,2,3,5,6,7,9,12,13};
        BinarySearch binarySearch = new BinarySearch();
        int i = binarySearch.binarySearch(arr, 11);
        System.out.println(i);
    }


}
