package realize.sort;

/**
 * Created by dell on 2021/9/12.
 */
public class InserSort {
    void sort(int[]arr){
        for (int i = 1; i < arr.length; ++i) {
            int value = arr[i];
            int j=i-1;
            for (;j>=0;--j){
                if(arr[j]>value){
                    arr[j+1]=arr[j];
                }else{
                    break;
                }
                arr[j+1]=value;
            }
        }
    }


    public static void main(String[] args) {
        int[]arr = new int[]{2,1,7,3,9,2,5};
        InserSort inserSort = new InserSort();
        inserSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
